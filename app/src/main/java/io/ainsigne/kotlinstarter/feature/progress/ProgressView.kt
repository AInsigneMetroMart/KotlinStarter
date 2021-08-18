package io.ainsigne.kotlinstarter.feature.progress

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import io.ainsigne.kotlinstarter.databinding.ViewProgressBinding


class ProgressView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    val binding = ViewProgressBinding.inflate(LayoutInflater.from(context), this)

    init {
        // Block clicks from child views while it's visible
        isClickable = true
    }

    fun show() {
        visibility = View.VISIBLE
    }

    fun hide() {
        visibility = View.GONE
    }
}
