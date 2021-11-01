package com.midterm.cryptonews.extensions


fun String.isAlphaNumeric():Boolean{
    return this.matches("^[a-zA-Z0-9]*$".toRegex())
}