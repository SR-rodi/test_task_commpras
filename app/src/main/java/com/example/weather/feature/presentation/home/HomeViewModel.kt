package com.example.weather.feature.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.extension.Log
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.Query
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: CurrentWeatherUseCase
) : ViewModel() {


    init {
        Log("start")
        viewModelScope.launch(Dispatchers.IO) {
            val test = useCase.getCurrentWeatherByCity(Query("London"))
            Log(test.TempCurrent)
        }
    }
}