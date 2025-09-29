package com.yakogdan.core.data.api.kinopoisk.mapper

import com.yakogdan.core.data.api.kinopoisk.dto.FilmDTO
import com.yakogdan.core.domain.model.FilmModel

fun FilmDTO.toModel() = FilmModel(
    id = id,
    name = nameRu ?: nameOriginal ?: "Empty name",
)