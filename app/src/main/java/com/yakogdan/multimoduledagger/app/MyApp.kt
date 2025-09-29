package com.yakogdan.multimoduledagger.app

import android.app.Application
import com.yakogdan.multimoduledagger.di.component.DaggerApplicationComponent

class MyApp : Application() {

    val applicationComponent by lazy {
        DaggerApplicationComponent.factory().create(this)
    }

    override fun onCreate() {
        applicationComponent.inject(this)
        super.onCreate()
    }
}