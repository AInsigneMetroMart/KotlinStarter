package io.ainsigne.kotlinstarter.view.viewmodel

import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.kotlinstarter.view.CurrentScreenHookProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

class GlobalExceptionHandler(
    private val analytics: AnalyticsClient,
    private val currentScreenHookProvider: CurrentScreenHookProvider
) : CoroutineExceptionHandler {

    override val key: CoroutineContext.Key<*>
        get() = CoroutineExceptionHandler

    override fun handleException(context: CoroutineContext, exception: Throwable) {
        analytics.sendHandledThrowable(exception)
        currentScreenHookProvider.currentScreenHook?.onNonRecoverableError(exception.localizedMessage.orEmpty())
    }
}
