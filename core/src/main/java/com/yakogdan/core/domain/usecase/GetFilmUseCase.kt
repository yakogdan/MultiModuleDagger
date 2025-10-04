package com.yakogdan.core.domain.usecase

import com.yakogdan.core.domain.model.FilmModel
import com.yakogdan.core.domain.repository.FilmRepository

class GetFilmUseCase(
    private val repository: FilmRepository,
) {

    suspend fun invoke(id: Int): FilmModel = repository.getFilm(id = id)
}