package com.example.weather.feature.data.dto

import com.example.weather.feature.domain.Weather

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
        weather.first().main,
        weather.first().description,
        wind.speed,
        clouds.all,
        main.temp,
        main.temp_min,
        main.temp_max,
        weather.first().icon,
        name,
    )
}