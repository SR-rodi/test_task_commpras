package com.example.weather.feature.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCase
import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.usecase.ListCityUseCase
import com.example.weather.feature.presentation.settings.SettingsViewModel
import com.example.weather.feature.presentation.home.HomeViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor (
    private val currentWeatherUseCase: CurrentWeatherUseCase,
    private val query: Query,
    private val listCityUseCase: ListCityUseCase
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            HomeViewModel::class.java -> HomeViewModel(currentWeatherUseCase,query) as T
            SettingsViewModel::class.java -> SettingsViewModel(query,listCityUseCase) as T
            else -> throw IllegalAccessError("error create viewModel")
        }

    }
}