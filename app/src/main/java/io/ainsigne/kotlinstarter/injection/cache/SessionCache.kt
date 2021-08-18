package io.ainsigne.kotlinstarter.injection.cache

import javax.inject.Qualifier


/**
 * Content obtained during the lifetime of the session
 */
@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class SessionCache
