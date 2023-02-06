package com.example.weather.feature.data.api

import com.example.weather.feature.data.dto.ResponseWeatherDto
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET(CURRENT_WEATHER)
    suspend fun getCurrentWeather(
        @Query("q") q:String,
        @Query("units") units:String = "metric",
        @Query("APPID") apiKey:String = API_KEY
    ):ResponseWeatherDto


    companion object {
        private const val API_KEY = "08f24250fa87dbd15710436993f6143f"
        private const val CURRENT_WEATHER = "data/2.5/weather"
        // api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=08f24250fa87dbd15710436993f6143f
    }
}