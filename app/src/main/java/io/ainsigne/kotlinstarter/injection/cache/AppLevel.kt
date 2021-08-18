package io.ainsigne.kotlinstarter.injection.cache

import javax.inject.Qualifier

/**
 * Represents the app level and should never get cleared
 */
@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class AppLevel
