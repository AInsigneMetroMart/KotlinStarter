package io.ainsigne.service

import com.google.gson.Gson

class Meta {
    var page: Page? = null
    override fun toString(): String {
        return Gson().toJson(this)
    }

    override fun hashCode(): Int {
        return toString().hashCode()
    }
}
