package com.yakogdan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yakogdan.core.domain.usecase.GetFilmUseCase
import com.yakogdan.core.domain.usecase.GetWeatherUseCase
import com.yakogdan.home.state.FilmScreenState
import com.yakogdan.home.state.WeatherScreenState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val getFilmUseCase: GetFilmUseCase,
    private val getWeatherUseCase: GetWeatherUseCase,
) : ViewModel() {

    private val filmExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _filmScreenState.value = FilmScreenState.Error(throwable)
    }

    private var _filmScreenState = MutableStateFlow<FilmScreenState>(FilmScreenState.Initial)
    val filmScreenState: StateFlow<FilmScreenState> = _filmScreenState.asStateFlow()

    fun loadFilm(filmId: Int) {
        viewModelScope.launch(filmExceptionHandler + Dispatchers.IO) {
            _filmScreenState.value = FilmScreenState.Loading
            _filmScreenState.value = FilmScreenState.Content(
                film = getFilmUseCase.invoke(id = filmId)
            )
        }
    }

    private val weatherExceptionHandler = CoroutineExceptionHandler { _, throwable ->
        _filmScreenState.value = FilmScreenState.Error(throwable)
    }

    private var _weatherScreenState =
        MutableStateFlow<WeatherScreenState>(WeatherScreenState.Initial)
    val weatherScreenState: StateFlow<WeatherScreenState> = _weatherScreenState.asStateFlow()

    fun loadWeather(city: String) {
        viewModelScope.launch(weatherExceptionHandler + Dispatchers.IO) {
            _weatherScreenState.value = WeatherScreenState.Loading
            _weatherScreenState.value = WeatherScreenState.Content(
                weather = getWeatherUseCase.invoke(city = city)
            )
        }
    }
}