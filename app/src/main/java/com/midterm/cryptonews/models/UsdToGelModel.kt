package com.midterm.cryptonews.models


import com.squareup.moshi.Json

data class UsdToGelModel(
    @Json(name = "USD_GEL")
    var usd_gel: Double?
)