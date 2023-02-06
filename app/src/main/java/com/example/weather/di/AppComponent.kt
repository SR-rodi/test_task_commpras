package com.example.weather.di

import com.example.weather.feature.presentation.viewmodelfactory.ViewModelFactory
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        RetrofitModule::class,
        Binds::class,
        RepositoryModule::class
    ]
)
interface AppComponent {

    val viewModelFactory: ViewModelFactory

}