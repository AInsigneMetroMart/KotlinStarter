package io.ainsigne.kotlinstarter.injection.repository

import dagger.Module
import dagger.Provides
import io.ainsigne.repository.fmcg.FmcgDao
import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.fmcg.FmcgRepositoryImpl
import io.ainsigne.repository.shop.ShopRepository
import io.ainsigne.repository.shop.ShopRepositoryImpl
import io.ainsigne.repository.shop.ShopsDao
import io.ainsigne.service.fmcg_campaigns.FmcgService
import io.ainsigne.service.shop.ShopService
import javax.inject.Singleton

@Suppress("LongParameterList")
@Module
class RepositoryModule {


    @Provides @Singleton fun provideShopRepository(
        shopService: ShopService,
        shopsDao: ShopsDao
    ): ShopRepository {
        return ShopRepositoryImpl(shopsDao = shopsDao,
                                shopService = shopService)
    }

    @Provides @Singleton fun provideFmcgRepository(
        fmcgService: FmcgService,
        fmcgDao: FmcgDao
    ): FmcgRepository {
        return FmcgRepositoryImpl(fmcgDao = fmcgDao, fmcgService = fmcgService)
    }

}
