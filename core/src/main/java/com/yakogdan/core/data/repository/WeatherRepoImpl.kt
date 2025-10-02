package com.yakogdan.core.data.repository

import com.yakogdan.core.data.api.openweathermap.OpenWeatherMapApiService
import com.yakogdan.core.data.api.openweathermap.mapper.toModel
import com.yakogdan.core.domain.model.WeatherModel
import com.yakogdan.core.domain.repository.WeatherRepository
import javax.inject.Inject

class WeatherRepoImpl @Inject constructor(
    private val weatherApiService: OpenWeatherMapApiService,
) : WeatherRepository {

    override suspend fun getWeather(city: String): WeatherModel =
        weatherApiService.getWeather(city = city).toModel()
}