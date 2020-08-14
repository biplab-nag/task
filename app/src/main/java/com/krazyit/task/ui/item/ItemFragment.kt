package com.krazyit.task.ui.item

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat

import com.krazyit.task.R
import com.krazyit.task.data.model.ProductsItem
import com.krazyit.task.ui.base.BaseFragment
import com.krazyit.task.utils.Utils
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.row_product.view.*
import timber.log.Timber

class ItemFragment : BaseFragment() {

    override fun setContentViewId(): Int {
        return R.layout.fragment_item
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        // Inflate the layout for this fragment
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val args:ItemFragmentArgs = ItemFragmentArgs.fromBundle(arguments)

        name.text = args.toBundle().getString("name")
        desc.text = HtmlCompat.fromHtml(args.toBundle().getString("desc"), HtmlCompat.FROM_HTML_MODE_LEGACY)
        price.text = "tk "+args.toBundle().getString("price")

        Utils.loadImageView(args.toBundle().getString("image"),R.drawable.img_placeholder,image)

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
