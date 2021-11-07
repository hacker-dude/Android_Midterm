package com.midterm.cryptonews.network

import com.midterm.cryptonews.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroApi {
    @GET("convert?q=USD_GEL&compact=ultra&apiKey=fbf7ed802e9e28ed4ec0")
    suspend fun getUsdToGel():Response<UsdToGelModel>

    @GET("markets")
    suspend fun getCoinMarket(
        @Query("ids") ids:String?,
        @Query("vs_currency") vs_currency:String,
        @Query("order") order:String,
        @Query("per_page") per_page:Int,
        @Query("page") page:Int,
        @Query("sparkline") sparkline:Boolean = false,
        ):Response<Array<MoshiMarketModel>>

    @GET("markets")
    suspend fun getCoinItem(
        @Query("ids") ids:String,
        @Query("vs_currency") vs_currency:String,
        @Query("order") order:String,
        @Query("per_page") per_page:Int,
        @Query("page") page:Int,
        @Query("sparkline") sparkline:Boolean = true,
    ):Response<Array<CoinItemModel>>

    @GET("news")
    suspend fun getNews(
        @Query("apikey") apikey:String = "pub_212097a98c2e86d07d88667208857afda045",
        @Query("page")page:Int,
        @Query("q") query:String,
        @Query("language") sparkline:String = "en",
    ):Response<NewsModel>
}