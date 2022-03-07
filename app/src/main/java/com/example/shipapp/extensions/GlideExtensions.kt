package com.example.shipapp.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(image: String){
    Glide.with(this).load(image).into(this)
}
