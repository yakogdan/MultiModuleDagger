package com.yakogdan.core.domain.usecase

import com.yakogdan.core.domain.model.WeatherModel
import com.yakogdan.core.domain.repository.WeatherRepository

class GetWeatherUseCase(
    private val repository: WeatherRepository,
) {

    suspend fun invoke(city: String): WeatherModel = repository.getWeather(city = city)
}