package com.smendon.android.dynamicdashboard.binding

import android.util.Log
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.smendon.android.dynamicdashboard.R

@BindingAdapter("imageURL")
fun AppCompatImageView.setImageURL(imageURL: String?) {
    Log.d("TAG", "url: $imageURL")
    if (!imageURL.isNullOrEmpty()) {
        Glide
            .with(this)
            .asBitmap()
            .load(imageURL)
            .fitCenter()
            .placeholder(R.drawable.ic_dmart)
            .error(R.drawable.ic_dmart)
            .into(this);
    }
}