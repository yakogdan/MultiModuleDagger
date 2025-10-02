package com.yakogdan.core.data.api.openweathermap.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeatherDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: MainDTO,
    @SerialName("name")
    val name: String?,
    @SerialName("weather")
    val weather: List<WeatherDTO?>?,
)