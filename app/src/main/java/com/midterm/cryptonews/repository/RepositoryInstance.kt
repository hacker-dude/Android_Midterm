package com.midterm.cryptonews.repository


import com.midterm.cryptonews.models.UsdToGelModel
import com.midterm.cryptonews.network.RetrofitInstance
import retrofit2.Response


class Repository {
    suspend fun getUsdToGel():Response<UsdToGelModel>{
        return RetrofitInstance.apiClient.getUsdToGel()
    }
}