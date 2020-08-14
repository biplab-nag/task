package com.krazyit.task.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.krazyit.task.R
import com.krazyit.task.ui.base.BaseFragment

class SearchFragment : BaseFragment() {

    override fun setContentViewId(): Int {
        return R.layout.fragment_search
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        return rootView
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun stopLoading() {
        TODO("Not yet implemented")
    }

    override fun showError(message: String?) {
        TODO("Not yet implemented")
    }

}
