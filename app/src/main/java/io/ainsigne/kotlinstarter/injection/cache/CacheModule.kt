package io.ainsigne.kotlinstarter.injection.cache

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import dagger.Module
import dagger.Provides
import io.ainsigne.repository.shop.ShopRepository
import io.ainsigne.repository.shop.ShopRepositoryImpl
import io.ainsigne.repository.shop.ShopsDao
import io.ainsigne.service.shop.ShopService
import javax.inject.Singleton

@Module
class CacheModule {

    @Provides @Singleton fun provideInt(): Int {
        return 1
    }

}
