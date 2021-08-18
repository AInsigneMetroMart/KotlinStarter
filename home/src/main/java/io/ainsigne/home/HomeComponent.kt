package io.ainsigne.home

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

@ActivityScope
@Component(
    dependencies = [AppComponent::class],
    modules = [HomeComponent.HomeModule::class]
)
interface HomeComponent {
    fun inject(activity: HomeActivity)

    @Module
    class HomeModule(val fragmentActivity: FragmentActivity) {
        @Provides
        fun providesHomeViewModel(
            coroutineContextProvider: CoroutineContextProvider,
            analytics: AnalyticsClient
        ): HomeViewModel {
            return ViewModelProvider(fragmentActivity, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return HomeViewModel(
                        coroutineContextProvider = coroutineContextProvider,
                        analytics = analytics
                    ) as T
                }
            })[HomeViewModel::class.java]
        }
    }
}