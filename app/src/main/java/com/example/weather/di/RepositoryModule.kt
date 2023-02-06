package com.example.weather.di

import com.example.weather.feature.data.api.WeatherApi
import com.example.weather.feature.data.repositoryImpl.CurrentWeatherRepositoryImpl
import com.example.weather.feature.domain.CurrentWeatherRepository
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun bindsCurrentWeatherRepositoryImpl(api: WeatherApi) = CurrentWeatherRepositoryImpl(api)

    @Provides
    @Singleton
    fun bindsCurrentWeatherUseCaseImpl(repository: CurrentWeatherRepository) =
        CurrentWeatherUseCaseImpl(repository)
}