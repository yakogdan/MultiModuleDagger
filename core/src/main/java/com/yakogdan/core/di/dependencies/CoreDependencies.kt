package com.yakogdan.core.di.dependencies

import com.yakogdan.core.domain.repository.FilmRepository

interface CoreDependencies {
    fun filmRepository(): FilmRepository
}

interface CoreDependenciesProvider {
    fun getCoreDependencies(): CoreDependencies
}