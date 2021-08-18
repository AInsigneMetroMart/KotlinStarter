package io.ainsigne.kotlinstarter.injection.app

import android.content.Context
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.kotlinstarter.injection.api.ApiModule
import io.ainsigne.kotlinstarter.injection.service.ServiceModule
import io.ainsigne.kotlinstarter.view.CurrentScreenHookProvider
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import dagger.Component
import io.ainsigne.kotlinstarter.injection.cache.CacheModule
import io.ainsigne.kotlinstarter.injection.dao.DaoModule
import io.ainsigne.kotlinstarter.injection.repository.RepositoryModule
import io.ainsigne.repository.converter.AiDatabase
import io.ainsigne.repository.fmcg.FmcgDao
import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.shop.ShopRepository
import io.ainsigne.repository.shop.ShopsDao
import io.ainsigne.service.fmcg_campaigns.FmcgService
import io.ainsigne.service.shop.ShopService
import javax.inject.Singleton

@Suppress("TooManyFunctions")
@Singleton
@Component(
    modules = [
        AppModule::class,
        CacheModule::class,
        RepositoryModule::class,
        DaoModule::class,
        ServiceModule::class,
        ApiModule::class,
    ]
)
interface AppComponent {

    // App module
    fun getContext(): Context
    fun getAnalytics(): AnalyticsClient
    fun getCoroutineContextProvider(): CoroutineContextProvider
    fun getCurrentScreenHookProvider(): CurrentScreenHookProvider

    // RepositoryModule
    fun getShopRepository(): ShopRepository
    fun getFmcgRepository(): FmcgRepository

    // DaoModule
    fun getAiDatabase(): AiDatabase
    fun getShopsDao(): ShopsDao
    fun getFmcgsDao(): FmcgDao

    // ServiceModule
    fun getShopService(): ShopService
    fun getFmcgService(): FmcgService

    // ApiModule
}
