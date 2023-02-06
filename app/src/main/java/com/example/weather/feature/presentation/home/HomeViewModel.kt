package com.example.weather.feature.presentation.home

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.lifecycle.viewModelScope
import com.example.weather.core.LoadState
import com.example.weather.core.base.BaseViewModel
import com.example.weather.feature.domain.model.Weather
import com.example.weather.feature.domain.settings.Query
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val useCase: CurrentWeatherUseCase,
    private val query: Query
) : BaseViewModel() {

    @SuppressLint("SimpleDateFormat")
    private val simpleDateFormat = SimpleDateFormat("EEEE, dd MMMM, yyyy")

    fun getDate(): String = simpleDateFormat
        .format(Calendar.getInstance().timeInMillis).replaceFirstChar(Char::titlecase)

    private val _weather = MutableStateFlow(Weather())
    val weather = _weather.asSharedFlow()


    fun start() {
        viewModelScope.launch(Dispatchers.IO + handler) {
            _loadState.value = LoadState.LOADING
            _weather.value = useCase.getCurrentWeatherByCity(query)
            _loadState.value = LoadState.SUCCESS
        }
    }
}