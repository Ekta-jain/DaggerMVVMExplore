package com.e4ekta.daggermvvmexplore.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.e4ekta.daggermvvmexplore.module.Product

@Database(entities = [Product::class], version = 1)
abstract class FakerDatabase : RoomDatabase() {

    abstract fun getFakerDao(): FakerDao
}