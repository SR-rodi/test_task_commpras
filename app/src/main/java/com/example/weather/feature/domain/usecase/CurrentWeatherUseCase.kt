package com.example.weather.feature.domain.usecase

import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.model.Weather

interface CurrentWeatherUseCase {

    suspend fun getCurrentWeatherByCity(query: Query): Weather
}