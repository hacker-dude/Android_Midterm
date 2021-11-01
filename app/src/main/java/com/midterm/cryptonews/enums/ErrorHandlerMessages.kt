package com.midterm.cryptonews.enums

enum class ErrorHandlerMessages(val message: String) {
    INVALID_EMAIL_FORMAT("Invalid Email Format"),
    THIS_FIELD_IS_REQUIRED("This Field Is Required"),
    USER_WITH_THIS_EMAIL_DOES_NOT_EXIST("No User Is Associated With This Email"),
    INVALID_PASSWORD("Incorrect Password"),
    PASSWORD_TOO_SHORT("Password Should Be At Least 6 Characters Long"),
    AUTH_FAILED("Authentication Failed"),
    INVALID_CHARS_USERNAME("Please Only Use AlphaNumeric Characters"),
    EMAIL_ALREADY_IN_USE("This Email Has Already Been Used")
}