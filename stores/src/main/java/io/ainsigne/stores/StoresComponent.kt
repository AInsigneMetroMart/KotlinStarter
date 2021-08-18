package io.ainsigne.stores

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
    modules = [StoresComponent.StoresModule::class]
)
interface StoresComponent {
    fun inject(fragmentActivity: StoresActivity)

    @Module
    class StoresModule(val fragmentActivity: FragmentActivity, val areaId: String) {
        @Provides
        fun providesStoresViewModel(
            coroutineContextProvider: CoroutineContextProvider,
            analytics: AnalyticsClient,
            fmcgRepository: FmcgRepository,
            shopRepository: ShopRepository,
            context: Context
        ): StoresViewModel {
            return ViewModelProvider(fragmentActivity, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return StoresViewModel(
                        coroutineContextProvider = coroutineContextProvider,
                        analytics = analytics,
                        fmcgRepository = fmcgRepository,
                        shopRepository = shopRepository,
                        areaId = areaId
                    ) as T
                }
            })[StoresViewModel::class.java]
        }
    }
}
