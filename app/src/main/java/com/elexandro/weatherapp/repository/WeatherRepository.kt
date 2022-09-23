package com.elexandro.weatherapp.repository

import com.elexandro.weatherapp.api.WeatherApi
import javax.inject.Inject

class WeatherRepository @Inject constructor(
    private val weatherApi: WeatherApi
) {
    suspend fun getWeather() = weatherApi.getWeather()
}