package io.ainsigne.kotlinstarter.injection

object Authorization {
    const val NAME = "Authorization"

    fun getValue(accessToken: String): String {
        return "Bearer $accessToken"
    }
}
