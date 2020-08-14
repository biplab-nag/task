package com.krazyit.task.ui.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.krazyit.task.R
import com.krazyit.task.data.api.ApiService
import com.krazyit.task.data.api.TheMovieDBClient
import com.krazyit.task.data.model.Products
import com.krazyit.task.data.repo.NetworkState
import com.krazyit.task.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_product.*


class ProductFragment : BaseFragment() {

    private lateinit var viewModel: ProductViewModel
    private lateinit var repo: ProductRepo

    override fun setContentViewId(): Int {
        return R.layout.fragment_product
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        initRepo()
        initViewModel()
        return rootView;
    }

    private fun initRepo() {
        val apiService : ApiService = TheMovieDBClient.getClient()
        repo = ProductRepo(apiService)
    }


    private fun initViewModel() {
        viewModel = getViewModel()

        viewModel.products.observe(viewLifecycleOwner, Observer {
            updateView(it)
        })

        viewModel.networkState.observe(viewLifecycleOwner, Observer {
            when (it) {
                NetworkState.LOADING -> {
                    showLoading()
                }
                NetworkState.LOADED -> {
                    stopLoading()
                }
                NetworkState.ERROR -> {
                    showError(it.msg)
                }
            }
        })
    }

    private fun getViewModel(): ProductViewModel {
        return ViewModelProviders.of(this, object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return ProductViewModel(
                    repo
                ) as T
            }
        })[ProductViewModel::class.java]
    }

    private fun updateView(it: Products?) {
        val adapter = ProductAdapter(products = it!!)
        val llm = LinearLayoutManager(context)
        llm.orientation = RecyclerView.VERTICAL
        rvProduct.layoutManager = llm
        rvProduct.adapter = adapter
    }


    override fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    override fun stopLoading() {
        progressBar.visibility = View.GONE
    }


    override fun showError(message : String?) {
        showError(message)
    }

}
