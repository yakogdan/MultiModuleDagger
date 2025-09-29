package com.yakogdan.multimoduledagger.di.components

import android.app.Application
import com.yakogdan.multimoduledagger.activity.MainActivity
import com.yakogdan.multimoduledagger.app.MyApp
import com.yakogdan.multimoduledagger.di.scope.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    modules = [

    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(application: MyApp)

    @Component.Factory
    interface Factory {

        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}