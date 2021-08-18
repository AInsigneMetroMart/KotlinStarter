package io.ainsigne.kotlinstarter.injection.api

import android.os.Build
import io.ainsigne.kotlinstarter.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*

class DeviceInfoInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request()
            .newBuilder()

        val appVersion = getAppVersion()
        val deviceName = getDeviceName()
        val osVersion = Build.VERSION.RELEASE
        requestBuilder.addHeader("User-Agent", "Android/$appVersion/$deviceName/$osVersion")

        return chain.proceed(requestBuilder.build())
    }

    private fun getAppVersion(): String {
        return BuildConfig.VERSION_NAME
    }

    private fun getDeviceName(): String {
        val manufacturer = Build.MANUFACTURER
        val model = Build.MODEL
        return when {
            model.startsWith(manufacturer) -> {
                model.toUpperCase(Locale.ROOT)
            }
            else -> "${manufacturer.toUpperCase(Locale.ROOT)} $model"
        }
    }
}

