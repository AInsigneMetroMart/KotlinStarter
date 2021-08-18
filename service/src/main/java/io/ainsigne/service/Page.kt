package io.ainsigne.service

import com.google.gson.Gson

class Page {
    var number = 0
    var size = 0
    var total = 0
    var prev = 0
    var next = 0
    var first = 0
    var last = 0
    var count = 0
    override fun toString(): String {
        return Gson().toJson(this)
    }
}