package com.example.weather.feature.data.repositoryImpl

import com.example.weather.feature.data.City
import com.example.weather.feature.domain.repository.ListCityRepository
import javax.inject.Inject

class ListCityRepositoryImpl @Inject constructor(
    private val listCity: List<City>
) : ListCityRepository {

    override fun getCity() = listCity
}