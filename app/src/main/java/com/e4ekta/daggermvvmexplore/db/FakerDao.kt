package com.e4ekta.daggermvvmexplore.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.e4ekta.daggermvvmexplore.module.Product

@Dao
interface FakerDao {

    @Insert
    suspend fun addProducts(product: List<Product>)
    // we added suspend bcz db se related all task
    // will perform on background thread

    @Query("SELECT * FROM Product")
    suspend fun getProducts() : List<Product>


}