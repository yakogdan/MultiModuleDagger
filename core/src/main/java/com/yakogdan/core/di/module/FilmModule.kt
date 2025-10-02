package com.yakogdan.core.di.module

import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiFactory
import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiService
import com.yakogdan.core.data.repository.FilmRepoImpl
import com.yakogdan.core.domain.repository.FilmRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
internal interface FilmModule {

    @Binds
    fun bindFilmRepository(repoImpl: FilmRepoImpl): FilmRepository

    companion object {

        @Provides
        fun provideKinopoiskApiService(): KinopoiskApiService =
            KinopoiskApiFactory.kinopoiskApiService
    }
}