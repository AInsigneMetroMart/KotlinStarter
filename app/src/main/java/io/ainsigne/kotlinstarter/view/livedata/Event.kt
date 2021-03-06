package io.ainsigne.kotlinstarter.view.livedata

/**
 * Used as a wrapper for data that is exposed via a LiveData that represents an event.
 */
open class Event<out T> constructor(private val content: T) {

    var hasBeenHandled = false
        private set // Allow external read but not write

    /**
     * Returns the content and prevents its use again.
     */
    fun getContentIfNotHandled(): T? {
        return if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            content
        }
    }

    /**
     * Returns the content, even if it's already been handled.
     */
    fun peekContent(): T = content

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Event<*>) return false

        if (content != other.content) return false
        if (hasBeenHandled != other.hasBeenHandled) return false

        return true
    }

    override fun hashCode(): Int {
        var result = content?.hashCode()
                ?: 0
        result = 31 * result + hasBeenHandled.hashCode()
        return result
    }

}

class UnitEvent : Event<Unit>(Unit)

