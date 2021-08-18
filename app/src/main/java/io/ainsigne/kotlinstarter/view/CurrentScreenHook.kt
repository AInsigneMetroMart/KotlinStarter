package io.ainsigne.kotlinstarter.view

interface CurrentScreenHook {
    fun onNonRecoverableError(errorMessage: String)
    fun onUnAuthorizedError()
}
