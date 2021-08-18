package io.ainsigne.service

import com.google.gson.Gson

class MultiEntityWrapper {
    var data: Array<Entity>? = null

    override fun toString(): String {
        return Gson().toJson(this)
    }
}