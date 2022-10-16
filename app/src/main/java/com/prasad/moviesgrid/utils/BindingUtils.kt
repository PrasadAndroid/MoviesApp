package com.prasad.moviesgrid.utils

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

/**
 * Created by Prasad on 15-10-2022.
 */
class BindingUtils {
    companion object {

        @BindingAdapter("android:visibility")
        @JvmStatic
        fun View.setVisibility(visible: Boolean) {
            visibility = if (visible) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        @BindingAdapter("android:visibility")
        @JvmStatic
        fun View.setVisibility(string: String?) {
            visibility = if (string?.isEmpty() == true) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }

        @BindingAdapter("movieItemPoster")
        @JvmStatic
        fun loadImage(imageView: ImageView, imageURL: String) {
            Picasso.get()
                .load("https://image.tmdb.org/t/p/w500/${imageURL}")
                .into(imageView)
        }
    }
}