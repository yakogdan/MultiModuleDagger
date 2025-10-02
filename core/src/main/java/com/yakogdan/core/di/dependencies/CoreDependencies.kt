package com.yakogdan.core.di.dependencies

import com.yakogdan.core.domain.repository.FilmRepository
import com.yakogdan.core.domain.repository.WeatherRepository

interface CoreDependencies {

    fun filmRepository(): FilmRepository
    fun weatherRepository(): WeatherRepository
}

interface CoreDependenciesProvider {
    fun getCoreDependencies(): CoreDependencies
}