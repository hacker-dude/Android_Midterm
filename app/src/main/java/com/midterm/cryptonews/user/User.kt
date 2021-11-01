package com.midterm.cryptonews.user

data class User(
    var username:String,
    var chosenCoins:ArrayList<String>? = null,
)
