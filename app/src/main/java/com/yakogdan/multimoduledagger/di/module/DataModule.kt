package com.yakogdan.multimoduledagger.di.module

import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiFactory
import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiService
import com.yakogdan.core.data.api.openweathermap.OpenWeatherMapApiFactory
import com.yakogdan.core.data.api.openweathermap.OpenWeatherMapApiService
import com.yakogdan.core.data.repository.FilmRepoImpl
import com.yakogdan.core.data.repository.WeatherRepoImpl
import com.yakogdan.core.domain.repository.FilmRepository
import com.yakogdan.core.domain.repository.WeatherRepository
import org.koin.dsl.module

val dataModule = module {

    single<KinopoiskApiService> {
        KinopoiskApiFactory.kinopoiskApiService
    }

    single<FilmRepository> {
        FilmRepoImpl(kinopoiskApiService = get())
    }

    single<OpenWeatherMapApiService> {
        OpenWeatherMapApiFactory.openWeatherMapApiService
    }

    single<WeatherRepository> {
        WeatherRepoImpl(weatherApiService = get())
    }
}