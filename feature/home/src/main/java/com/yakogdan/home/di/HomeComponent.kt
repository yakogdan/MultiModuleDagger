package com.yakogdan.home.di

import com.yakogdan.core.di.dependencies.CoreDependencies
import com.yakogdan.core.di.module.ViewModelFactoryModule
import com.yakogdan.home.HomeFragment
import dagger.Component

@HomeScope
@Component(
    modules = [
        HomeModule::class,
        ViewModelFactoryModule::class,
    ],
    dependencies = [
        CoreDependencies::class,
    ],
)
interface HomeComponent {

    fun inject(fragment: HomeFragment)

    @Component.Factory
    interface Factory {

        fun create(dependencies: CoreDependencies): HomeComponent
    }
}