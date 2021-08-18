package io.ainsigne.kotlinstarter.feature.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import io.ainsigne.kotlinstarter.view.livedata.observeIfNotConsumed
import io.ainsigne.kotlinstarter.databinding.ActivitySplashBinding
import io.ainsigne.kotlinstarter.injection.app.InjectUtils
import io.ainsigne.kotlinstarter.view.BaseActivity
import javax.inject.Inject

class SplashActivity : BaseActivity() {

//    companion object {
//        private const val DELAYED_CLOSE_ANIMATION_MS = 1_000L
//    }

    @Inject lateinit var viewmodel: SplashViewModel

//    private val handler = Handler(Looper.getMainLooper())

    override fun inject() {
        DaggerSplashComponent
            .builder()
            .appComponent(InjectUtils.getComponent(applicationContext))
            .splashModule(SplashComponent.SplashModule(activity()))
            .build()
            .inject(this)
    }




    @Suppress("SpreadOperator")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(viewmodel) {
            openHomeScreenEvent.observeIfNotConsumed(activity()) {
                //appNavigator.openHome(activity())
                startActivity(prepareIntent(activityStores))
                finish()
            }

            openSessionExpired.observeIfNotConsumed(activity()) {
                //appNavigator.openSessionExpired(activity())
                finish()
            }

            openOnboardingScreenEvent.observeIfNotConsumed(activity()) {
//                val intent = appNavigator.getOnboardingIntent(activity())
//                val sharedElements = TransitionHelper.createShareTransitionPairsFromViews(activity(), emptyList())
//                val activityOptions = ActivityOptionsCompat.makeSceneTransitionAnimation(activity(), *sharedElements)
//                activity().startActivity(intent, activityOptions.toBundle())
//                handler.postDelayed(DELAYED_CLOSE_ANIMATION_MS) { activity().finish() }
            }
        }
    }
}
