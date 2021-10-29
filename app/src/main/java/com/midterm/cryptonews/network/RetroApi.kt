package com.midterm.cryptonews.network

import com.midterm.cryptonews.models.UsdToGelModel
import retrofit2.Response
import retrofit2.http.GET

interface RetroApi {
    @GET("convert?q=USD_GEL&compact=ultra&apiKey=fbf7ed802e9e28ed4ec0")
    suspend fun getUsdToGel():Response<UsdToGelModel>
}