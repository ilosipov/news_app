package com.ilosipov.news_app.util

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.ilosipov.news_app.R

/**
 * Class BindingAdapter
 * @author Ilya Osipov (mailto:il.osipov.gm@gmail.com)
 * @since 20.11.2020
 * @version $Id$
 */

object BindingAdapter {

    @JvmStatic
    @BindingAdapter("glide_url")
    fun loadImg(imageView: ImageView, url: String?) =
            Glide.with(imageView.context).load(url).into(imageView)

    @JvmStatic
    @BindingAdapter("glide_circular")
    fun loadUserImage(imageView: ImageView, url: String?) =
            Glide.with(imageView.context).load(url).circleCrop().into(imageView)

    @JvmStatic
    @BindingAdapter("set_background")
    fun setBackground(imageView: ImageView, color: String?) =
            when (color) {
                "RED" -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.red))
                "BLACK" -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.black_II))
                "YELLOW" -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.yellow))
                "BLUE" -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.blue))
                "PURPLE" -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.purple))
                else -> imageView.setBackgroundColor(ContextCompat.getColor(imageView.context, R.color.red))
            }
}