package io.ainsigne.analytics

interface AnalyticsClient {
    fun screenView(screenview: AnalyticsScreen)
    fun sendHandledThrowable(throwable: Throwable)
}