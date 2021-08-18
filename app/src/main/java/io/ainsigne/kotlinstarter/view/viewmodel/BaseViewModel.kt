package io.ainsigne.kotlinstarter.view.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel(coroutineContextProvider: CoroutineContextProvider) : ObservableViewModel(), CoroutineScope {

    private val viewModelJob = SupervisorJob()

    protected val ioScope = CoroutineScope(coroutineContextProvider.ioScope + viewModelJob)
    protected val mainScope = CoroutineScope(coroutineContextProvider.mainScope + viewModelJob)

    override val coroutineContext: CoroutineContext = ioScope.coroutineContext

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
