package com.example.weather.di

import com.example.weather.feature.data.City
import com.example.weather.feature.data.api.WeatherApi
import com.example.weather.feature.data.repositoryImpl.CurrentWeatherRepositoryImpl
import com.example.weather.feature.data.repositoryImpl.ListCityRepositoryImpl
import com.example.weather.feature.domain.repository.CurrentWeatherRepository
import com.example.weather.feature.domain.repository.ListCityRepository
import com.example.weather.feature.domain.usecase.impl.CurrentWeatherUseCaseImpl
import com.example.weather.feature.domain.usecase.impl.ListCityUseCaseImpl
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
    fun providesListCityRepositoryImpl(listCity: List<City>) = ListCityRepositoryImpl(listCity)

    @Provides
    @Singleton
    fun providesCurrentWeatherUseCaseImpl(
        repository: CurrentWeatherRepository, mapIcon: Map<String, Int>
    ) = CurrentWeatherUseCaseImpl(repository, mapIcon)

    @Provides
    @Singleton
    fun providesListCityUseCaseImpl(repository: ListCityRepository) =
        ListCityUseCaseImpl(repository)
}