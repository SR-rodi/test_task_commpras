package com.example.weather.feature.domain

interface CurrentWeatherUseCase {

    suspend fun getCurrentWeatherByCity(query: Query):Weather
}