package com.yakogdan.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yakogdan.core.domain.usecase.GetFilmUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val getFilmUseCase: GetFilmUseCase,
) : ViewModel() {

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