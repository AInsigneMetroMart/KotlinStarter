package io.ainsigne.service

import com.google.gson.Gson

class SingleEntityResponse : EntityResponse() {
    var data: Entity? = null
    override fun toString(): String {
        return Gson().toJson(this)
    }
}