package com.example.weather.di

import com.example.weather.feature.data.repositoryImpl.CurrentWeatherRepositoryImpl
import com.example.weather.feature.data.repositoryImpl.ListCityRepositoryImpl
import com.example.weather.feature.domain.repository.CurrentWeatherRepository
import com.example.weather.feature.domain.repository.ListCityRepository
import com.example.weather.feature.domain.usecase.CurrentWeatherUseCase
import com.example.weather.feature.domain.usecase.ListCityUseCase
import com.example.weather.feature.domain.usecase.impl.CurrentWeatherUseCaseImpl
import com.example.weather.feature.domain.usecase.impl.ListCityUseCaseImpl
import javax.inject.Singleton

@dagger.Module
interface Binds {

    @dagger.Binds
    @Singleton
    fun bindsCurrentWeatherRepository(
        repositoryImpl: CurrentWeatherRepositoryImpl
    ): CurrentWeatherRepository

    @dagger.Binds
    @Singleton
    fun bindsListCityRepository(
        repositoryImpl: ListCityRepositoryImpl
    ): ListCityRepository

    @dagger.Binds
    @Singleton
    fun bindsCurrentWeatherUseCase(useCaseImpl: CurrentWeatherUseCaseImpl): CurrentWeatherUseCase

    @dagger.Binds
    @Singleton
    fun bindsListCityUseCase(useCaseImpl: ListCityUseCaseImpl): ListCityUseCase
}