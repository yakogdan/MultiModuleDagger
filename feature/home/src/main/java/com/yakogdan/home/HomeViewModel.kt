package com.yakogdan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiFactory
import com.yakogdan.core.data.api.kinopoisk.KinopoiskApiService
import com.yakogdan.core.data.repository.FilmRepoImpl
import com.yakogdan.core.domain.repository.FilmRepository
import com.yakogdan.core.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val kinopoiskApiService: KinopoiskApiService = KinopoiskApiFactory.kinopoiskApiService

    private val repository: FilmRepository = FilmRepoImpl(kinopoiskApiService = kinopoiskApiService)

    private val getFilmUseCase = GetFilmUseCase(repository = repository)

    private var _filmScreenState = MutableStateFlow<FilmScreenState>(FilmScreenState.Initial)
    val filmScreenState: StateFlow<FilmScreenState> = _filmScreenState.asStateFlow()

    fun loadFilm(filmId: Int) {
        viewModelScope.launch {
            _filmScreenState.value = FilmScreenState.Loading
            _filmScreenState.value = FilmScreenState.Content(
                film = getFilmUseCase.invoke(id = filmId)
            )
        }
    }
}