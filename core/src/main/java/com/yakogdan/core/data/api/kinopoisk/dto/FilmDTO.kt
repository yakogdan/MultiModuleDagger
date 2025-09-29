package com.yakogdan.core.data.api.kinopoisk.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmDTO(
    @SerialName("kinopoiskId")
    val id: Int,
    @SerialName("description")
    val description: String?,
    @SerialName("nameRu")
    val nameRu: String?,
    @SerialName("nameOriginal")
    val nameOriginal: String?,
    @SerialName("posterUrl")
    val posterUrl: String?,
    @SerialName("posterUrlPreview")
    val posterUrlPreview: String?,
    @SerialName("year")
    val year: Int?,
)