package com.yakogdan.core.domain.repository

import com.yakogdan.core.domain.model.FilmModel

interface FilmRepository {

    suspend fun getFilm(id: Int): FilmModel
}