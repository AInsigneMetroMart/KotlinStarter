package io.ainsigne.kotlinstarter.injection.app

import android.content.Context

object InjectUtils {
    fun getComponent(applicationContext: Context): AppComponent {
        return if (applicationContext is AppComponentProvider) {
            (applicationContext as AppComponentProvider).provideBaseComponent()
        } else {
            throw IllegalStateException("Provide the application context which implement AppComponentProvider")
        }
    }
}
