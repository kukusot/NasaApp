package com.ikukushev.nasaapp.core

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.ikukushev.nasaapp.core.widget.RatioImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.Target
import java.lang.Exception

fun ImageView.displayUrl(imageUrl: String) {
    Picasso.get().load(imageUrl).into(this)
}

fun RatioImageView.displayImageWithRatio(imageUrl: String) {
    Picasso.get().load(imageUrl).into(object : Target {

        override fun onPrepareLoad(placeHolderDrawable: Drawable?) {

        }

        override fun onBitmapFailed(e: Exception?, errorDrawable: Drawable?) {

        }

        override fun onBitmapLoaded(bitmap: Bitmap, from: Picasso.LoadedFrom?) {
            val width = bitmap.width
            val height = bitmap.height
            this@displayImageWithRatio.ratio = height.toFloat() / width
            setImageBitmap(bitmap)
        }
    })
}