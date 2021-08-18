package io.ainsigne.kotlinstarter.injection.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import io.ainsigne.kotlinstarter.injection.TimberLoggingInterceptor
import io.ainsigne.utilities.Constants
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import javax.inject.Singleton

@Module
class ApiModule {


    @Provides @Singleton fun providesGson(): Gson {
        return GsonBuilder().setLenient().create()
    }

    @Provides @Singleton @AuthClient
    fun createClient(): OkHttpClient {
        val httpClient = OkHttpClient
            .Builder()
            .followRedirects(true)
            .followSslRedirects(true)
            .retryOnConnectionFailure(true)
            .cache(null)
            .connectTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .addInterceptor(DeviceInfoInterceptor())


        return httpClient.build()
    }

    companion object {
        private const val DEFAULT_REQUEST_TIME_OUT_SECONDS = 30L
    }

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson): Retrofit {

        val builder = OkHttpClient
            .Builder()
            .addInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                    .apply {
                        header("Content-Type", "application/json")
                        header("Accept", "application/json, text/plain, */*")
                    }
                chain.proceed(requestBuilder.build());
            }
            .connectTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .readTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)
            .writeTimeout(DEFAULT_REQUEST_TIME_OUT_SECONDS, TimeUnit.SECONDS)

        return Retrofit.Builder()
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl(Constants.serverUrl)
            .build()
    }
}
