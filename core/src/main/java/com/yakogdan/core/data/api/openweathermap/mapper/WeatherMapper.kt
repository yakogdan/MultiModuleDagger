package com.yakogdan.core.data.api.openweathermap.mapper

import com.yakogdan.core.data.api.openweathermap.dto.CurrentWeatherDTO
import com.yakogdan.core.domain.model.WeatherModel

fun CurrentWeatherDTO.toModel(): WeatherModel =
    WeatherModel(
        id = id,
        city = name.orEmpty(),
        temp = main.temp ?: 0.0,
        description = weather?.first()?.description ?: "Empty"
    )