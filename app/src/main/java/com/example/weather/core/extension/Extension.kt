package com.example.weather.core.extension

import android.content.Context
import com.example.weather.app.App
import com.example.weather.di.AppComponent

fun <T> Log(log: T) =
    android.util.Log.e("Kart", "$log")


fun Context.appComponent(): AppComponent =
    when (this) {
        is App -> appComponent
        else -> this.applicationContext.appComponent()
    }
