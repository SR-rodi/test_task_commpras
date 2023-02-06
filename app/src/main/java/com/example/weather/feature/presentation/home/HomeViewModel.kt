package com.example.weather.feature.presentation.home

import android.annotation.SuppressLint
import android.icu.util.Calendar
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.core.extension.Log
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.Query
import com.example.weather.feature.domain.Weather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
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

    fun getCityName() =query.city

    private val _weather = MutableSharedFlow<Weather>()
    val weather = _weather.asSharedFlow()

    init {
        Log("start")
        viewModelScope.launch(Dispatchers.IO) {
            val test = useCase.getCurrentWeatherByCity(query)
            _weather.emit(test)
            Log(test.clouds)
        }
    }
}