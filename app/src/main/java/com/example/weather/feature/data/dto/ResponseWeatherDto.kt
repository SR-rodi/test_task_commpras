package com.example.weather.feature.data.dto

import com.example.weather.feature.domain.model.Weather

class ResponseWeatherDto(
    private val clouds: CloudsDto,
    private val id: Int,
    private val main: MainDto,
    private val weather: List<WeatherDto>,
    private val wind: WindDto,
    private val name: String,
) {
    fun toWeather() = Weather(
        id,
        main.humidity,
        main.pressure,
        weather.first().description,
        wind.speed,
        clouds.all,
        main.temp,
        weather.first().icon,
        name,
    )
}