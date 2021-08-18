package io.ainsigne.kotlinstarter.injection.cache

import javax.inject.Qualifier

/**
 * Represents the user level for encrypted content
 */
@Qualifier
@MustBeDocumented
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
annotation class UserEncryptedLevel
