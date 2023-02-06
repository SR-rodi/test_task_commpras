package com.example.weather.feature.domain.usecase

import com.example.weather.R
import com.example.weather.core.extension.Log
import com.example.weather.feature.domain.CurrentWeatherRepository
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.Query
import com.example.weather.feature.domain.Weather
import javax.inject.Inject

class CurrentWeatherUseCaseImpl @Inject constructor(
    private val repository: CurrentWeatherRepository,
    private val mapIcons: Map<String, Int>
) : CurrentWeatherUseCase {

    override suspend fun getCurrentWeatherByCity(query: Query): Weather {
        val weather = repository.getCurrentWeatherByCity(query)
        Log(" ${weather.iconName} =  ${mapIcons[weather.iconName]}")
        weather.icon = mapIcons[weather.iconName] ?: R.drawable.ic_error
        return weather
    }

}