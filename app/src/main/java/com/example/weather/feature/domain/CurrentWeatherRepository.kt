package com.example.weather.feature.domain



interface CurrentWeatherRepository {

    suspend fun getCurrentWeatherByCity(query: Query):Weather

}