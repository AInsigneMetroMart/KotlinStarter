package io.ainsigne.kotlinstarter.injection.service

import dagger.Module
import dagger.Provides
import io.ainsigne.service.departments.DepartmentService
import io.ainsigne.service.fmcg_campaigns.FmcgService
import io.ainsigne.service.products.ProductService
import io.ainsigne.service.shop.ShopService
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class ServiceModule {

    @Provides @Singleton fun provideShopService(retrofit: Retrofit): ShopService {
        return retrofit.create(ShopService::class.java)
    }

    @Provides @Singleton fun provideDepartment(retrofit: Retrofit): DepartmentService {
        return retrofit.create(DepartmentService::class.java)
    }

    @Provides @Singleton fun provideProduct(retrofit: Retrofit): ProductService {
        return retrofit.create(ProductService::class.java)
    }

    @Provides @Singleton fun provideFmcg(retrofit: Retrofit): FmcgService {
        return retrofit.create(FmcgService::class.java)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptors: ArrayList<Interceptor>
    ): OkHttpClient {
        val clientBuilder = OkHttpClient.Builder()
            .followRedirects(false)
        interceptors.forEach {
            clientBuilder.addInterceptor(it)
        }
        return clientBuilder.build()
    }
}
