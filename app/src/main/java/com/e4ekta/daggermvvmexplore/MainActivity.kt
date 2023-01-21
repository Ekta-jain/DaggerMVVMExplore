package com.e4ekta.daggermvvmexplore


import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.e4ekta.daggermvvmexplore.viewmodels.MainViewModel
import com.e4ekta.daggermvvmexplore.viewmodels.MainViewModelFactory
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory

    private val products: TextView
    get() = findViewById(R.id.products)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as FakerApplication).applicationComponent.inject(this)
        // hume dagger ko btana hoga ke yha field injection lagaya, isko intialize kr do
        //for that we need to mention Component
        mainViewModel = ViewModelProvider(this, mainViewModelFactory ).get(MainViewModel::class.java)

        mainViewModel.productsLiveData.observe(this, Observer {
           products.text =  it.joinToString { x -> x.title+"\n\n" }
        })
    }
}