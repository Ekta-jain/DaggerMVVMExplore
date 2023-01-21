package com.e4ekta.daggermvvmexplore.retrofit

import com.e4ekta.daggermvvmexplore.module.Product
import retrofit2.Response
import retrofit2.http.GET

interface FakerAPI {

    @GET("products")
   suspend fun getProducts(): Response<List<Product>>
}