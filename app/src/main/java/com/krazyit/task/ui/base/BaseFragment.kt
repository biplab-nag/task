package com.krazyit.task.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.CallSuper
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment


abstract class BaseFragment: Fragment() {

    protected var rootView: View? = null

    abstract fun setContentViewId(): Int

    abstract fun showLoading()

    abstract fun stopLoading()

    abstract fun showError(message: String?)

    @CallSuper
    override fun onCreateView(@NonNull inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(setContentViewId(), container, false)
        return rootView
    }

    protected open fun showToast(message: String?) {
        Toast.makeText(context, message,Toast.LENGTH_SHORT).show()
    }
}