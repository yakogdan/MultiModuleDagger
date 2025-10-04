package com.yakogdan.multimoduledagger.app

import android.app.Application
import com.yakogdan.multimoduledagger.di.module.appModule
import com.yakogdan.multimoduledagger.di.module.dataModule
import com.yakogdan.multimoduledagger.di.module.domainModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidLogger(level = Level.DEBUG)

            androidContext(androidContext = this@MyApp)

            modules(
                modules = listOf(
                    appModule,
                    dataModule,
                    domainModule,
                ),
            )
        }
    }
}