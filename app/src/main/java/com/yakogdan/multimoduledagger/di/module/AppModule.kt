package com.yakogdan.multimoduledagger.di.module

import com.yakogdan.home.HomeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<HomeViewModel> {
        HomeViewModel(
            getFilmUseCase = get(),
            getWeatherUseCase = get(),
        )
    }
}