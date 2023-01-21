package com.e4ekta.daggermvvmexplore

import android.app.Application
import com.e4ekta.daggermvvmexplore.di.ApplicationComponent
import com.e4ekta.daggermvvmexplore.di.DaggerApplicationComponent

class FakerApplication: Application() {
    lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent =  DaggerApplicationComponent.builder().build()
    }
}