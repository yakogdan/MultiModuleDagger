package com.yakogdan.core.data.api.kinopoisk

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create

object KinopoiskApiFactory {

    private const val BASE_URL = "https://kinopoiskapiunofficial.tech/"

    private val json: Json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
        .build()

    val kinopoiskApiService: KinopoiskApiService = retrofit.create()
}