package com.example.weather.feature.domain.usecase

import com.example.weather.feature.domain.settings.City

interface ListCityUseCase {

    fun getListCity(name: String): List<City>
}