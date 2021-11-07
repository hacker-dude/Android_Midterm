package com.midterm.cryptonews.models


import com.squareup.moshi.Json

data class NewsModel(
    var nextPage: Int?,
    var results: List<Result>?,
    var status: String?,
    var totalResults: Int?
) {
    data class Result(
        var content: String?,
        var creator: List<String?>?,
        var description: String?,
        @Json(name = "full_description")
        var fullDescription: String?,
        @Json(name = "image_url")
        var imageUrl: String?,
        var keywords: List<String?>?,
        var link: String?,
        var pubDate: String?,
        @Json(name = "source_id")
        var sourceId: String?,
        var title: String?,
        @Json(name = "video_url")
        var videoUrl: String?
    )
}