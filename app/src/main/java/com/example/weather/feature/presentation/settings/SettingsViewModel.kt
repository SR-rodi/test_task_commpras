package com.example.weather.feature.presentation.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.feature.domain.settings.City
import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.usecase.ListCityUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val query: Query,
    private val listCityUseCase: ListCityUseCase,
) : ViewModel() {

    private val _city = MutableStateFlow<List<City>>(emptyList())
    val city = _city.asSharedFlow()

    init {
        getListCity()
    }

    private fun getListCity() =
        viewModelScope.launch {
            _city.value = listCityUseCase.getListCity(query.city)
        }


    fun setCiteInQuery(name: String) =
        viewModelScope.launch {
            query.city = name
            _city.value = listCityUseCase.getListCity(query.city)
        }

}