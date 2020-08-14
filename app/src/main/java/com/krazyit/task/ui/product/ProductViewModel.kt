package com.krazyit.task.ui.product

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.krazyit.task.data.repo.NetworkState
import com.krazyit.task.data.model.Products
import io.reactivex.disposables.CompositeDisposable

class ProductViewModel (private val movieRepository : ProductRepo)  : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val  products : LiveData<Products> by lazy {
        movieRepository.fetchSingleMovieDetails(compositeDisposable)
    }

    val networkState : LiveData<NetworkState> by lazy {
        movieRepository.getMovieDetailsNetworkState()
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}