package com.example.weather.feature.domain.repository

import com.example.weather.feature.data.City

interface ListCityRepository {
    fun getCity(): List<City>
}