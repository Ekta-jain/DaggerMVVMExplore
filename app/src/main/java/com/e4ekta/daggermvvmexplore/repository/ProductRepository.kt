package com.e4ekta.daggermvvmexplore.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.e4ekta.daggermvvmexplore.db.FakerDatabase
import com.e4ekta.daggermvvmexplore.module.Product
import com.e4ekta.daggermvvmexplore.retrofit.FakerAPI
import javax.inject.Inject

class ProductRepository @Inject constructor(private val fakerApi: FakerAPI, private val fakerDatabase: FakerDatabase) {
    private val _products = MutableLiveData<List<Product>>()
    val product: LiveData<List<Product>>
    get() = _products

    suspend fun getProducts(){
        val result = fakerApi.getProducts()
        if(result.isSuccessful && result.body()!=null){
            //list of producd added
            fakerDatabase.getFakerDao().addProducts(result.body()!!)
            _products.postValue(result.body())
        }
    }


}