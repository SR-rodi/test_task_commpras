package com.example.weather.feature.domain.usecase

import com.example.weather.feature.domain.CurrentWeatherRepository
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.Query
import javax.inject.Inject

class CurrentWeatherUseCaseImpl @Inject constructor(private val repository: CurrentWeatherRepository) :
    CurrentWeatherUseCase {

    override suspend fun getCurrentWeatherByCity(query: Query) =
        repository.getCurrentWeatherByCity(query)
}