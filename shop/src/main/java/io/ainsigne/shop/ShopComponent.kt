package io.ainsigne.shop

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Component
import dagger.Module
import dagger.Provides
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.kotlinstarter.injection.app.ActivityScope
import io.ainsigne.kotlinstarter.injection.app.AppComponent
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.shop.ShopRepository

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [ShopComponent.ShopModule::class]
)
interface ShopComponent {
    fun inject(fragment: ShopFragment)

    @Module
    class ShopModule(val fragmentActivity: FragmentActivity, val shopId: String) {
        @Provides
        fun providesShopViewModel(
            coroutineContextProvider: CoroutineContextProvider,
            analytics: AnalyticsClient,
            shopRepository: ShopRepository,
            fmcgRepository: FmcgRepository,
            context: Context
        ): ShopViewModel {
            return ViewModelProvider(fragmentActivity, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return ShopViewModel(
                        coroutineContextProvider = coroutineContextProvider,
                        analytics = analytics,
                        shopRepository = shopRepository,
                        fmcgRepository = fmcgRepository,
                        shopId = shopId
                    ) as T
                }
            })[ShopViewModel::class.java]
        }
    }
}
