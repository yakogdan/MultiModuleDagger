package com.yakogdan.core.di.component

import com.yakogdan.core.di.dependencies.CoreDependencies
import com.yakogdan.core.di.module.FilmModule
import com.yakogdan.core.di.scope.CoreScope
import dagger.Component

@CoreScope
@Component(
    modules = [
        FilmModule::class,
    ]
)
interface CoreComponent : CoreDependencies {


    @Component.Factory
    interface Factory {

        fun create(): CoreComponent
    }
}