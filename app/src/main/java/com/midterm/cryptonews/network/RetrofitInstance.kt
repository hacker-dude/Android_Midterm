package com.midterm.cryptonews.network

import com.midterm.cryptonews.network.Constants.Companion.CONVERTER_BASE_URL
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val okHttpClient by lazy {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(loggingInterceptor)
        builder.build()
    }

    val apiClient : RetroApi by lazy {
        Retrofit.Builder()
            .baseUrl(CONVERTER_BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(MoshiConverterFactory.create(
                Moshi.Builder()
                    .addLast(KotlinJsonAdapterFactory())
                    .build()
            ))
            .build().create(RetroApi::class.java)
    }

}