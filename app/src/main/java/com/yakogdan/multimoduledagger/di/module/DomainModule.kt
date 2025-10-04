package com.yakogdan.multimoduledagger.di.module

import com.yakogdan.core.domain.usecase.GetFilmUseCase
import com.yakogdan.core.domain.usecase.GetWeatherUseCase
import org.koin.dsl.module

val domainModule = module {

    factory<GetFilmUseCase> {
        GetFilmUseCase(repository = get())
    }

    factory<GetWeatherUseCase> {
        GetWeatherUseCase(repository = get())
    }
}