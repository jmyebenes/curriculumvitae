package com.jmyebenes.curriculum.core.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(context)
        .asBitmap()
        .load(url)
        .into(this)
}