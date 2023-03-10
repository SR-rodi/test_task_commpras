package com.example.weather.di

import com.example.weather.feature.data.api.WeatherApi
import com.example.weather.feature.domain.settings.Query
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@dagger.Module
class RetrofitModule {

    @Provides
    @Singleton
    fun providerRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): WeatherApi = retrofit.create()

    @Provides
    @Singleton
    fun provideQuery() = Query()

    companion object {
        private const val BASE_URL = "https://api.openweathermap.org/"
    }
}