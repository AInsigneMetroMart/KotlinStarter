package io.ainsigne.home


import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.kotlinstarter.view.viewmodel.BaseViewModel
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import kotlinx.coroutines.launch


class HomeViewModel(
    private val coroutineContextProvider: CoroutineContextProvider,
    private val analytics: AnalyticsClient,
) : BaseViewModel(coroutineContextProvider) {

    init {
//        ioScope.launch {
//
//        }
    }
}
