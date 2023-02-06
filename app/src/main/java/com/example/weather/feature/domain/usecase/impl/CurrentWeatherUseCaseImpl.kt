package com.example.weather.feature.domain.usecase.impl

import com.example.weather.R
import com.example.weather.feature.domain.repository.CurrentWeatherRepository
import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.model.Weather
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCase
import javax.inject.Inject

class CurrentWeatherUseCaseImpl @Inject constructor(
    private val repository: CurrentWeatherRepository,
    private val mapIcons: Map<String, Int>
) : CurrentWeatherUseCase {

    override suspend fun getCurrentWeatherByCity(query: Query): Weather {
        val weather = repository.getCurrentWeatherByCity(query)
        weather.icon = mapIcons[weather.iconName] ?: R.drawable.ic_error
        return weather
    }

}