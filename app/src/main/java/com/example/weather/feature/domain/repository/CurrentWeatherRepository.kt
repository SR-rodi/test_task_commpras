package com.example.weather.feature.domain.repository

import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.model.Weather


interface CurrentWeatherRepository {

    suspend fun getCurrentWeatherByCity(query: Query): Weather
}