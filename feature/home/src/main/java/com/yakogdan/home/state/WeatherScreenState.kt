package com.yakogdan.home.state

import com.yakogdan.core.domain.model.WeatherModel

sealed interface WeatherScreenState {

    data class Content(val weather: WeatherModel) : WeatherScreenState

    data object Initial : WeatherScreenState

    data object Loading : WeatherScreenState

    data class Error(val throwable: Throwable) : WeatherScreenState
}