package com.yakogdan.core.api.openweathermap

import com.yakogdan.core.api.openweathermap.dto.CurrentWeather
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenWeatherMapApiService {

    @GET("data/2.5/weather")
    suspend fun getWeather(
        @Query("q") city: String,
        @Query("appid") apiKey: String = API_KEY,
        @Query("lang") lang: String = "ru",
        @Query("units") units: String = "metric"
    ): CurrentWeather

    companion object {
        private const val API_KEY = "e98a5f2a5a5ca9c353c06b901f89834e"
    }
}