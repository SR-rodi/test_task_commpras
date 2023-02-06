package com.example.weather.feature.data

import com.example.weather.R

class DefaultSettings {
    val iconMap = mapOf(
        Pair("11d", R.drawable.lightning),
        Pair("09d", R.drawable.cloud_rain),
        Pair("10d", R.drawable.sun_rain),
        Pair("13d", R.drawable.snow),
        Pair("50d", R.drawable.mist),
        Pair("01d", R.drawable.sun),
        Pair("02d", R.drawable.sun_cloud),
        Pair("03d", R.drawable.cloud),
        Pair("04d", R.drawable.very_clouds),
        Pair("01n", R.drawable.sun),
        Pair("02n", R.drawable.sun_cloud),
        Pair("03n", R.drawable.cloud),
        Pair("04n", R.drawable.very_clouds),
    )

    val listCity = listOf(
        City("London", "Лондон"),
        City("Volgograd", "Волгоград"),
        City("Moscow", "Москва"),
        City("Istanbul", "Стамбул"),
        City("Venice", "Венеция"),
        City("Rio de Janeiro", "Рио де Жанейро"),
        City("Amsterdam", "Амстердам"),
        City("Prague", "Прага"),
    )
}
