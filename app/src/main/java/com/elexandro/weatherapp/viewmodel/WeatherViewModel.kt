package com.elexandro.weatherapp.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.elexandro.weatherapp.model.Weather
import com.elexandro.weatherapp.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeatherViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
) : ViewModel() {
    private val _response = MutableLiveData<Weather>()
    val responseWeather : LiveData<Weather>
    get() = _response

    init {
        getWeather()
    }

    private fun getWeather() = viewModelScope.launch {
        weatherRepository.getWeather().let {
            if(it.isSuccessful) {
                _response.postValue(it.body())
            }
            else {
                Log.d("Error", "get weather Erros Response: ${it.message()}")
            }
        }
    }
}