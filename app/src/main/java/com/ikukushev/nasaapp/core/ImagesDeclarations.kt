package com.ikukushev.nasaapp.core

import android.widget.ImageView
import com.squareup.picasso.Picasso

fun ImageView.displayUrl(imageUrl: String) {
    Picasso.get().load(imageUrl).into(this)
}