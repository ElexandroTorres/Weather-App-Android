package com.elexandro.weatherapp.api

import com.elexandro.weatherapp.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {

    @GET("weather/Natal")
    suspend fun getWeather() : Response<Weather>
}