package com.yakogdan.multimoduledagger.app

import android.app.Application
import com.yakogdan.core.di.component.DaggerCoreComponent
import com.yakogdan.core.di.dependencies.CoreDependencies
import com.yakogdan.core.di.dependencies.CoreDependenciesProvider
import com.yakogdan.multimoduledagger.di.component.DaggerApplicationComponent

class MyApp : Application(), CoreDependenciesProvider {

    val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    val coreComponent by lazy {
        DaggerCoreComponent.factory().create()
    }

    override fun onCreate() {
        applicationComponent.inject(this)
        super.onCreate()
    }

    override fun getCoreDependencies(): CoreDependencies = coreComponent
}