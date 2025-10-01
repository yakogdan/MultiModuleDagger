package com.yakogdan.core.di.module

import androidx.lifecycle.ViewModelProvider
import com.yakogdan.core.di.factory.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {

    @Binds
    fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}