package com.yakogdan.home.state

import com.yakogdan.core.domain.model.FilmModel

sealed interface FilmScreenState {

    data class Content(val film: FilmModel) : FilmScreenState

    data object Initial : FilmScreenState

    data object Loading : FilmScreenState

    data class Error(val throwable: Throwable) : FilmScreenState
}