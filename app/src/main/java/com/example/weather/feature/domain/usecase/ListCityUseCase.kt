package com.example.weather.feature.domain.usecase

import com.example.weather.feature.data.City

interface ListCityUseCase {

    fun getListCity(name: String): List<City>
}