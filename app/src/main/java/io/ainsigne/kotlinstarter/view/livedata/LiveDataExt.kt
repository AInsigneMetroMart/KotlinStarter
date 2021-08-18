package io.ainsigne.kotlinstarter.view.livedata

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

fun <T> LiveData<Event<T>>.observeIfNotConsumed(
    lifecycleOwner: LifecycleOwner?,
    observingBlock: (T) -> Unit
) {
    lifecycleOwner?.let {
        observe(it, Observer { event ->
            event
                .getContentIfNotHandled()
                ?.let { value ->
                    observingBlock(value)
                }
        })
    }
}

fun LiveData<UnitEvent>.observeIfNotConsumed(
    lifecycleOwner: LifecycleOwner?,
    observingBlock: () -> Unit
) {
    lifecycleOwner?.let {
        observe(it, Observer { event ->
            event
                .getContentIfNotHandled()
                ?.let {
                    observingBlock()
                }
        })
    }
}

fun MutableLiveData<UnitEvent>.postEvent() = this.postValue(UnitEvent())

fun <T> MutableLiveData<Event<T>>.postEvent(value: T) = this.postValue(Event(value))
