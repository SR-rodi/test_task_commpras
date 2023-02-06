package com.example.weather.feature.presentation.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCaseImpl
import com.example.weather.feature.presentation.home.HomeViewModel
import javax.inject.Inject

@Suppress("UNCHECKED_CAST")
class ViewModelFactory @Inject constructor (
   private val useCase: CurrentWeatherUseCaseImpl
        ) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return when (modelClass) {
            HomeViewModel::class.java -> HomeViewModel(useCase) as T
            else -> throw IllegalAccessError("error create viewModel")
        }

    }
}