package com.example.weather.feature.data.repositoryImpl

import com.example.weather.feature.data.api.WeatherApi
import com.example.weather.feature.domain.repository.CurrentWeatherRepository
import com.example.weather.feature.domain.settings.Query
import javax.inject.Inject

class CurrentWeatherRepositoryImpl @Inject constructor(private val weatherApi: WeatherApi) :
    CurrentWeatherRepository {

    override suspend fun getCurrentWeatherByCity(query: Query) =
        weatherApi.getCurrentWeather(query.city, query.units).toWeather()
}