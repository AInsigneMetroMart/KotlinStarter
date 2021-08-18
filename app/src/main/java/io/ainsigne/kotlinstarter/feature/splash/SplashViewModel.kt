package io.ainsigne.kotlinstarter.feature.splash

import androidx.lifecycle.MutableLiveData
import io.ainsigne.kotlinstarter.view.livedata.postEvent
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.analytics.AnalyticsScreen
import io.ainsigne.kotlinstarter.view.livedata.UnitEvent
import io.ainsigne.kotlinstarter.view.viewmodel.BaseViewModel
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider

class SplashViewModel(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val analytics: AnalyticsClient
) : BaseViewModel(coroutineContextProvider) {

//    companion object {
//        private const val ONE_SECOND = 1000L
//    }

    val openOnboardingScreenEvent = MutableLiveData<UnitEvent>()
    val openHomeScreenEvent = MutableLiveData<UnitEvent>()
    val openSessionExpired = MutableLiveData<UnitEvent>()

    init {
        analytics.screenView(AnalyticsScreen("splash_screen"))
        //openOnboardingScreenEvent.postEvent()
        openHomeScreenEvent.postEvent()
        // Splash needs to decide to send the user to the onboarding, or home screen

    }
}
