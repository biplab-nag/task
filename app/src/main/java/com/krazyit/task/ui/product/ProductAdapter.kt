package com.krazyit.task.ui.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.krazyit.task.R
import com.krazyit.task.data.model.ProductsItem
import com.krazyit.task.utils.App
import com.krazyit.task.utils.Utils
import kotlinx.android.synthetic.main.row_product.view.*
import timber.log.Timber


class ProductAdapter(val products: ArrayList<ProductsItem>) : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_product, parent, false)
        return ViewHolder(view)

    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product: ProductsItem = products[position]
        holder.bindItems(product = product)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressWarnings("all")
        fun bindItems(product: ProductsItem) {

            var desc:String = product.prodDescription
            if (desc == null) desc = "N/A";

            itemView.name.text = product.prodName
            itemView.desc.text = HtmlCompat.fromHtml(desc, HtmlCompat.FROM_HTML_MODE_LEGACY)
            itemView.price.text = "tk "+product.prodPrice

            var path:String = getImagePath(product.prodImages)

            Utils.loadImageView(path,R.drawable.img_placeholder,itemView.image)

            itemView.setOnClickListener {
                var bundle = bundleOf("name" to product.prodName,
                "price" to product.prodPrice,
                "image" to path,
                "desc" to product.prodDescription)

                Navigation.findNavController(itemView).navigate(R.id.to_detailFragment,bundle)
            }
        }

        private fun getImagePath(images:List<String>?):String {
            val path = buildString{
                append(App.appContext.getString(R.string.IMG_BASE_URL))
                append(images?.get(0))
            }
            return path;
        }

    }

}