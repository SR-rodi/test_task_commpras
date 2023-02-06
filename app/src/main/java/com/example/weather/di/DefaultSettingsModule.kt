package com.example.weather.di

import com.example.weather.feature.data.DefaultSettings
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DefaultSettingsModule {

    @Provides
    @Singleton
    fun providesMapWeatherIcons() = DefaultSettings().iconMap

    @Provides
    @Singleton
    fun providesListCity() = DefaultSettings().listCity
}