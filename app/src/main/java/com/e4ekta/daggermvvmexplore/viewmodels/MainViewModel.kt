package com.e4ekta.daggermvvmexplore.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.e4ekta.daggermvvmexplore.module.Product
import com.e4ekta.daggermvvmexplore.repository.ProductRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: ProductRepository) : ViewModel() {

    val productsLiveData : LiveData<List<Product>>
    get() = repository.product

    init {
        viewModelScope.launch{
            repository.getProducts()
        }
    }
}