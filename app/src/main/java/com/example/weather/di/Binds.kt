package com.example.weather.di

import com.example.weather.feature.data.repositoryImpl.CurrentWeatherRepositoryImpl
import com.example.weather.feature.domain.CurrentWeatherRepository
import com.example.weather.feature.domain.CurrentWeatherUseCase
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCaseImpl
import javax.inject.Singleton

@dagger.Module
interface Binds {

    @dagger.Binds
    @Singleton
    fun bindsCurrentWeatherRepository(repositoryImpl: CurrentWeatherRepositoryImpl): CurrentWeatherRepository

    @dagger.Binds
    @Singleton
    fun bindsCurrentWeatherUseCase(useCaseImpl: CurrentWeatherUseCaseImpl):CurrentWeatherUseCase
}