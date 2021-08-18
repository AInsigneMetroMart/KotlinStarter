package io.ainsigne.kotlinstarter.feature.splash

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
    modules = [SplashComponent.SplashModule::class]
)
interface SplashComponent {
    fun inject(activity: SplashActivity)

    @Module
    class SplashModule(val fragmentActivity: FragmentActivity) {
        @Provides
        fun providesSplashViewModel(
            coroutineContextProvider: CoroutineContextProvider,
            analytics: AnalyticsClient
        ): SplashViewModel {
            return ViewModelProvider(fragmentActivity, object : ViewModelProvider.Factory {
                override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                    return SplashViewModel(
                        coroutineContextProvider = coroutineContextProvider,
                        analytics = analytics
                    ) as T
                }
            })[SplashViewModel::class.java]
        }
    }
}
