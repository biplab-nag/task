package com.krazyit.task.ui.product

import androidx.lifecycle.LiveData
import com.krazyit.task.data.api.ApiService
import com.krazyit.task.data.repo.ProductDataSource
import com.krazyit.task.data.repo.NetworkState
import com.krazyit.task.data.model.Products
import io.reactivex.disposables.CompositeDisposable

class ProductRepo (private val apiService : ApiService) {

    lateinit var movieDetailsProductDataSource: ProductDataSource

    fun fetchSingleMovieDetails (compositeDisposable: CompositeDisposable) : LiveData<Products> {

        movieDetailsProductDataSource = ProductDataSource(apiService,compositeDisposable)
        movieDetailsProductDataSource.fetchProducts()

        return movieDetailsProductDataSource.productsResponse

    }

    fun getMovieDetailsNetworkState(): LiveData<NetworkState> {
        return movieDetailsProductDataSource.networkState
    }



}