package com.e4ekta.daggermvvmexplore.di

import com.e4ekta.daggermvvmexplore.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface ApplicationComponent {

    fun inject(mainActivity:MainActivity)
}