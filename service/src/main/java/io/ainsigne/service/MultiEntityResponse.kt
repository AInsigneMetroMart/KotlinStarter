package io.ainsigne.service

import com.google.gson.Gson

class MultiEntityResponse : EntityResponse() {
    var meta: Meta? = null
    var data: List<Entity> = ArrayList()
    override fun toString(): String {
        return Gson().toJson(this)
    }
}