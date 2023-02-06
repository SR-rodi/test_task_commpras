package com.example.weather.feature.domain.usecase.impl

import com.example.weather.feature.domain.repository.ListCityRepository
import com.example.weather.feature.domain.usecase.ListCityUseCase
import javax.inject.Inject

class ListCityUseCaseImpl @Inject constructor(
    private val repository: ListCityRepository
) : ListCityUseCase {

    override fun getListCity(name: String) = repository.getCity().map { city ->
        city.isSelected = city.name == name
        city
    }
}