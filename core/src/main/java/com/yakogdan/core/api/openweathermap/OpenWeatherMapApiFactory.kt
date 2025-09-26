package com.yakogdan.core.api.openweathermap

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.create

object OpenWeatherMapApiFactory {

    private const val BASE_URL = "https://api.openweathermap.org/"

    private val json: Json = Json { ignoreUnknownKeys = true }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(json.asConverterFactory(MediaType.get("application/json")))
        .build()

    val openWeatherMapApiService: OpenWeatherMapApiService = retrofit.create()
}