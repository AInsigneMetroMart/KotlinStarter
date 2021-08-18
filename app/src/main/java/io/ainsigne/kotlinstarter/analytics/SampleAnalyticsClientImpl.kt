package io.ainsigne.kotlinstarter.analytics

import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.analytics.AnalyticsScreen
import timber.log.Timber


class SampleAnalyticsClientImpl : AnalyticsClient {
    override fun screenView(screen: AnalyticsScreen) {
        Timber.d(" Send Handled $screen ")
    }

    override fun sendHandledThrowable(throwable: Throwable) {
        Timber.d(" Send Handled $throwable ")
    }

}
