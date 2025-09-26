package com.yakogdan.core.api.kinopoisk

import com.yakogdan.core.api.kinopoisk.dto.FilmDTO
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path

interface KinopoiskApiService {

    @Headers("X-API-KEY: $API_KEY")
    @GET("/api/v2.2/films/{id}")
    suspend fun getFilmById(
        @Path("id") id: Int,
    ): FilmDTO

    companion object {
        private const val API_KEY = "7560e292-123f-4ea3-98a5-f42d521bad24"
    }
}