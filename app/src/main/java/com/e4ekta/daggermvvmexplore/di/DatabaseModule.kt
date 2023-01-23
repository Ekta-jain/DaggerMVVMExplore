package com.e4ekta.daggermvvmexplore.di

import android.content.Context
import androidx.room.Room
import com.e4ekta.daggermvvmexplore.db.FakerDao
import com.e4ekta.daggermvvmexplore.db.FakerDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideFakerDb(context : Context) : FakerDatabase{
        return Room.databaseBuilder(context, FakerDatabase::class.java,"FakerDB").build()
    }

}