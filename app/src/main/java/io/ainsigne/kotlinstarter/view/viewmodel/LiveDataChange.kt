package io.ainsigne.kotlinstarter.view.viewmodel

import android.os.Handler
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Uses an object internally to update changes to a livedata
 * All changes happen on the main coroutine dispatcher to
 * avoid concurrency conflicts.
 *
 * This wrapper class was built because getting the value of a liveDate might not be
 * the latest one. The purpose was to replicate behaviorSubject by getting the latest
 * value and updating its content and then posting it back
 */
class LiveDataChange<T>(
    private var buffer: T,
    private val handler: Handler = Handler()
) {
    private val data = MutableLiveData(buffer)

    fun value(): T = buffer

    /**
     * Provides the liveData
     */
    fun get(): LiveData<T> = data

    /**
     * onUpdated provides a callback that the data has been updated
     */
    fun update(onUpdated: ((T) -> Unit)? = null, transform: T.() -> T) {
        handler.post {
            buffer
                .let { it.transform() }
                .also {
                    data.postValue(it)
                    buffer = it
                }

            onUpdated?.invoke(buffer)
        }
    }
}
