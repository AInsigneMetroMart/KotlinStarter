package io.ainsigne.service

import com.google.gson.Gson

abstract class EntityResponse {
    var included: Array<Entity>? = null
    override fun toString(): String {
        return Gson().toJson(this)
    }
}