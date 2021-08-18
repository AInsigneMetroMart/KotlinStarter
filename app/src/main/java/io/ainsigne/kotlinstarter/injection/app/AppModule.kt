package io.ainsigne.kotlinstarter.injection.app

import android.app.Application
import android.content.Context
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.analytics.SampleAnalyticsClientImpl
import io.ainsigne.kotlinstarter.view.CurrentScreenHookProvider
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import io.ainsigne.kotlinstarter.view.viewmodel.GlobalExceptionHandler
import kotlinx.coroutines.CoroutineExceptionHandler
import javax.inject.Singleton


@Module
class AppModule(private val application: Application) {

    @Provides @Singleton fun provideAnalyticsService(): AnalyticsClient {
        return SampleAnalyticsClientImpl()
    }

    @Provides fun provideAppContext(): Context = application.applicationContext

    @Provides @Singleton fun provideCurrentScreenHookProvider(): CurrentScreenHookProvider {
        return CurrentScreenHookProvider()
    }



    @Provides @Singleton fun provideCoroutineExceptionHandler(
        analytics: AnalyticsClient,
        currentScreenHookProvider: CurrentScreenHookProvider
    ): CoroutineExceptionHandler {
        return GlobalExceptionHandler(
            analytics = analytics,
            currentScreenHookProvider = currentScreenHookProvider
        )
    }

    @Provides @Singleton fun provideCoroutineContextProvider(coroutineExceptionHandler: CoroutineExceptionHandler): CoroutineContextProvider {
        return CoroutineContextProvider(coroutineExceptionHandler = coroutineExceptionHandler)
    }
}
