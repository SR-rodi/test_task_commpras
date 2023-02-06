package com.example.weather.di

import com.example.weather.feature.data.api.WeatherApi
import com.example.weather.feature.data.repositoryImpl.CurrentWeatherRepositoryImpl
import com.example.weather.feature.domain.CurrentWeatherRepository
import com.example.weather.feature.domain.WeatherIcon
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCaseImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesCurrentWeatherRepositoryImpl(api: WeatherApi) = CurrentWeatherRepositoryImpl(api)

    @Provides
    @Singleton
    fun providesCurrentWeatherUseCaseImpl(repository: CurrentWeatherRepository,mapIcon: Map<String,Int>) =
        CurrentWeatherUseCaseImpl(repository,mapIcon)

    @Provides
    @Singleton
    fun providesMapWeatherIcons() = WeatherIcon().iconMap
}