package com.yakogdan.core.data.repository

import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiService
import com.yakogdan.core.data.api.kinopoisk.mapper.toModel
import com.yakogdan.core.domain.model.FilmModel
import com.yakogdan.core.domain.repository.FilmRepository

class FilmRepoImpl(
    private val kinopoiskApiService: KinopoiskApiService,
) : FilmRepository {

    override suspend fun getFilm(id: Int): FilmModel =
        kinopoiskApiService.getFilmById(id = id).toModel()
}