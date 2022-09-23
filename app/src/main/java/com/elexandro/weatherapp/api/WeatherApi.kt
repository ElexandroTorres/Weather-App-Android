package com.elexandro.weatherapp.api

interface WeatherApi {

    @GET("weather/Natal")
    suspend fun getWeather() :
}