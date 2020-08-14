package com.krazyit.task.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.krazyit.task.R
import org.jetbrains.annotations.NotNull

class Utils {
    companion object{
        fun loadImageView(@NotNull url: String?,
                          @NotNull placeHolderImage: Int?,
                          imageView: ImageView?) {
            placeHolderImage?.let {
                imageView?.let { it1 ->
                    Glide.with(App.appContext)
                        .load(url)
                        .placeholder(it)
                        .error(R.drawable.img_placeholder)
                        .into(it1)
                }
            }
        }
    }

}