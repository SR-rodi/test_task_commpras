package com.example.weather.feature.presentation.home

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCase
import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.model.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: CurrentWeatherUseCase,
    private val query: Query
) : ViewModel() {

    @SuppressLint("SimpleDateFormat")
    private val simpleDateFormat = SimpleDateFormat("EEEE, dd MMMM, yyyy")

    fun getDate(): String = simpleDateFormat.format(Calendar.getInstance().timeInMillis)

    private val _weather = MutableStateFlow(Weather())
    val weather = _weather.asSharedFlow()


    fun start() {
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = useCase.getCurrentWeatherByCity(query)
        }
    }

}