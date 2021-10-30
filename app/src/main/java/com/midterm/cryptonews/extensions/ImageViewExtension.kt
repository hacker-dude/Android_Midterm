package com.midterm.cryptonews.extensions

import android.view.View
import android.widget.ImageView
import androidx.lifecycle.coroutineScope
import androidx.lifecycle.findViewTreeLifecycleOwner
import com.bumptech.glide.Glide
import com.midterm.cryptonews.R
import kotlinx.coroutines.*


fun ImageView.setBcgGlide(url:String?){
    if(!url.isNullOrEmpty()){
        Glide.with(context)
            .load(url).placeholder(R.mipmap.ic_launcher)
            .error(R.mipmap.ic_launcher).into(this)
    }
    else{
        setImageResource(R.mipmap.ic_launcher)
    }
}

val <T> T.exhaustive: T
    get() = this