package com.yakogdan.core.api.openweathermap.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentWeather(
    @SerialName("id")
    val id: Int,
    @SerialName("main")
    val main: Main,
    @SerialName("name")
    val name: String?,
    @SerialName("weather")
    val weather: List<Weather?>?,
)