package com.yakogdan.core.domain.usecase

import com.yakogdan.core.domain.model.WeatherModel
import com.yakogdan.core.domain.repository.WeatherRepository
import javax.inject.Inject

class GetWeatherUseCase @Inject constructor(
    private val repository: WeatherRepository,
) {

    suspend fun invoke(city: String): WeatherModel = repository.getWeather(city = city)
}