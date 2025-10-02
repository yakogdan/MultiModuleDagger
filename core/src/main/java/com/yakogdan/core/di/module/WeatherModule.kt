package com.yakogdan.core.di.module

import com.yakogdan.core.data.api.openweathermap.OpenWeatherMapApiFactory
import com.yakogdan.core.data.api.openweathermap.OpenWeatherMapApiService
import com.yakogdan.core.data.repository.WeatherRepoImpl
import com.yakogdan.core.di.scope.CoreScope
import com.yakogdan.core.domain.repository.WeatherRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface WeatherModule {

    @[Binds CoreScope]
    fun bindWeatherRepository(repoImpl: WeatherRepoImpl): WeatherRepository

    companion object {

        @[Provides CoreScope]
        fun provideWeatherApiService(): OpenWeatherMapApiService =
            OpenWeatherMapApiFactory.openWeatherMapApiService
    }
}