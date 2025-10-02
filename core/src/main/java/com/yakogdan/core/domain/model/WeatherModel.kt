package com.yakogdan.core.domain.model

data class WeatherModel(
    val id: Int,
    val city: String,
    val temp: Double,
    val description: String,
)