package com.yakogdan.home.di

import androidx.lifecycle.ViewModel
import com.yakogdan.core.di.factory.ViewModelKey
import com.yakogdan.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface HomeModule {

    @Binds
    @[IntoMap ViewModelKey(HomeViewModel::class)]
    fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}