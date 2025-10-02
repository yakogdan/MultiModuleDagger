package com.yakogdan.core.domain.repository

import com.yakogdan.core.domain.model.WeatherModel

interface WeatherRepository {

    suspend fun getWeather(city: String): WeatherModel
}