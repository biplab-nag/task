package com.krazyit.task.data.repo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.krazyit.task.data.api.ApiService
import com.krazyit.task.data.model.Products
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class ProductDataSource (private val apiService : ApiService, private val compositeDisposable: CompositeDisposable) {

    private val _networkState  = MutableLiveData<NetworkState>()
    val networkState: LiveData<NetworkState>
        get() = _networkState

    private val _productsResponse =  MutableLiveData<Products>()
    val productsResponse: LiveData<Products>
        get() = _productsResponse

    fun fetchProducts() {
        _networkState.postValue(NetworkState.LOADING)

        try {
            compositeDisposable.add(
                apiService.getProducts()
                    .subscribeOn(Schedulers.io())
                    .subscribe(
                        {
                            _productsResponse.postValue(it)
                            _networkState.postValue(NetworkState.LOADED)
                        },
                        {
                            _networkState.postValue(NetworkState.ERROR)
                            Timber.e( it)
                        }
                    )
            )

        }

        catch (e: Exception){
            Timber.e(e)
        }


    }
}