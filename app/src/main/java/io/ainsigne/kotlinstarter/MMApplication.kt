package io.ainsigne.kotlinstarter

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.facebook.stetho.Stetho
import io.ainsigne.kotlinstarter.injection.app.AppComponent
import io.ainsigne.kotlinstarter.injection.app.AppComponentProvider
import io.ainsigne.kotlinstarter.injection.app.AppModule
import io.ainsigne.kotlinstarter.injection.app.DaggerAppComponent
import timber.log.Timber

class MMApplication : MultiDexApplication(), AppComponentProvider {


    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Stetho.initializeWithDefaults(this)
        }

        setUpAppComponent()
    }

    private fun setUpAppComponent() {
        appComponent = createDependencyInjector().build()
    }

    open fun createDependencyInjector(): DaggerAppComponent.Builder {
        return DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
    }

    fun recreateDependencyInjectionTree() {
        setUpAppComponent()
    }

    override fun provideBaseComponent(): AppComponent {
        return appComponent
    }
}
