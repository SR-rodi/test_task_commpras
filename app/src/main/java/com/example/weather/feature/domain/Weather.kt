package com.example.weather.feature.domain

class Weather(
   val id: Int,
   val weatherMaine: String,
   val weatherDescriptions: String,
   val windSpeed: Double,
   val clouds: Int,
   val TempCurrent: Double,
   val TempMin: Double,
   val TempMax: Double,
)