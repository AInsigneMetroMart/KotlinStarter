package io.ainsigne.kotlinstarter.view.viewmodel

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class CoroutineContextProvider constructor(coroutineExceptionHandler: CoroutineExceptionHandler) {
    open val mainScope: CoroutineContext by lazy { Dispatchers.Main + coroutineExceptionHandler }
    open val ioScope: CoroutineContext by lazy { Dispatchers.IO + coroutineExceptionHandler }
    open val appScope: CoroutineContext by lazy { Dispatchers.IO + coroutineExceptionHandler }
}
