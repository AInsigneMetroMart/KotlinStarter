package io.ainsigne.kotlinstarter.injection.app

import io.ainsigne.kotlinstarter.injection.app.AppComponent

interface AppComponentProvider {
    fun provideBaseComponent(): AppComponent
}
