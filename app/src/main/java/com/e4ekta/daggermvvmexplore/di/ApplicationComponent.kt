package com.e4ekta.daggermvvmexplore.di

import android.content.Context
import com.e4ekta.daggermvvmexplore.MainActivity
import dagger.BindsInstance
import dagger.Component
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DatabaseModule::class])
interface ApplicationComponent {

    fun inject(mainActivity:MainActivity)

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance context: Context) : ApplicationComponent
    }

    //Binding context on this component, so whenever needed can get from module
}