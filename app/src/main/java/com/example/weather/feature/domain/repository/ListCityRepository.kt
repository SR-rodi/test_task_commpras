package com.example.weather.feature.domain.repository

import com.example.weather.feature.domain.settings.City

interface ListCityRepository {
    fun getCity(): List<City>
}