package io.ainsigne.kotlinstarter.view

import android.view.View
import kotlin.math.abs

object ViewExt

fun View.setVisibility(
    visible: Boolean,
    hiddenViewVisibility: Int = View.GONE
) {
    visibility = if (visible) View.VISIBLE else hiddenViewVisibility
}

/**
 * It calculates the alpha remaining and adjust the duration of the animation
 * then sets the visibility as expected
 */
fun View.setVisibilityWithAlphaAnimation(visible: Boolean, durationMs: Int = 200, hiddenViewVisibility: Int = View.GONE) {
    val alphaEnd = if (visible) 1f else 0f
    val diff = abs(alphaEnd - alpha)
    val durationAnimationMs = durationMs * diff
    val alphaAnimation = animate().alpha(alphaEnd)
    alphaAnimation.duration = durationAnimationMs.toLong()
    setVisibility(visible = visible, hiddenViewVisibility = hiddenViewVisibility)
}
