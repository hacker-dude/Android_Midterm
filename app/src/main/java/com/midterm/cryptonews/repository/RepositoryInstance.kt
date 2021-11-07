package com.midterm.cryptonews.repository


import android.util.Log
import com.midterm.cryptonews.models.*
import com.midterm.cryptonews.network.RetrofitInstance
import retrofit2.Response


class Repository {
    suspend fun getUsdToGel():UsdToGelModel{
        val res = RetrofitInstance.converterClient.getUsdToGel()
        val body = res.body()!!
        return if (res.isSuccessful){
            body
        }else{
            UsdToGelModel(-1.0)
        }
    }
    suspend fun getCoinPrices(ids:ArrayList<String>,vs_c:String,order:String,per_page:Int,page:Int,sparkline:Boolean):Response<Array<MoshiMarketModel>>{
        val idsString = ids.joinToString(separator = ",")
        Log.d("holdup",idsString)
        return RetrofitInstance.apiClient.getCoinMarket(idsString,vs_c,order,per_page,page,sparkline)
    }
    suspend fun getCoinItem(id:String,vs_c:String,order:String,per_page:Int,page:Int,sparkline:Boolean = true):Response<Array<CoinItemModel>>{
        return RetrofitInstance.apiClient.getCoinItem(id,vs_c,order,per_page,page,sparkline)
    }
}