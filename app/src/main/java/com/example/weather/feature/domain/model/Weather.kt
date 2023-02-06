package com.example.weather.feature.domain.model

class Weather(
    val id: Int = 0,
    val humidity: Int = 0,
    val pressure: Int = 0,
    val weatherDescriptions: String = "",
    val windSpeed: Double = .0,
    val clouds: Int = 0,
    val TempCurrent: Double = .0,
    val iconName: String = "",
    val cityName: String = "",
    var icon: Int = 0,
)