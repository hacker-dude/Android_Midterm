package com.midterm.cryptonews.models


import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@JsonClass(generateAdapter = true)
@Parcelize
data class MoshiMarketModel(
        var ath: Double?,
        @Json(name = "ath_change_percentage")
        var athChangePercentage: Double?,
        @Json(name = "ath_date")
        var athDate: String?,
        var atl: Double?,
        @Json(name = "atl_change_percentage")
        var atlChangePercentage: Double?,
        @Json(name = "atl_date")
        var atlDate: String?,
        @Json(name = "circulating_supply")
        var circulatingSupply: Double?,
        @Json(name = "current_price")
        var currentPrice: Double?,
        @Json(name = "fully_diluted_valuation")
        var fullyDilutedValuation: Long?,
        @Json(name = "high_24h")
        var high24h: Double?,
        var id: String?,
        var image: String?,
        @Json(name = "last_updated")
        var lastUpdated: String?,
        @Json(name = "low_24h")
        var low24h: Double?,
        @Json(name = "market_cap")
        var marketCap: Long?,
        @Json(name = "market_cap_change_24h")
        var marketCapChange24h: Double?,
        @Json(name = "market_cap_change_percentage_24h")
        var marketCapChangePercentage24h: Double?,
        @Json(name = "market_cap_rank")
        var marketCapRank: Double?,
        @Json(name = "max_supply")
        var maxSupply: Long?,
        var name: String?,
        @Json(name = "price_change_24h")
        var priceChange24h: Double?,
        @Json(name = "price_change_percentage_24h")
        var priceChangePercentage24h: Double?,
        var symbol: String?,
        @Json(name = "total_supply")
        var totalSupply: Long?,
        @Json(name = "total_volume")
        var totalVolume: Long?,
):Parcelable
