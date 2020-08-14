package com.krazyit.task.data.api

import com.krazyit.task.data.model.Products
import io.reactivex.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("customer/get-recommend-product")
    fun getProducts(): Observable<Products>
}