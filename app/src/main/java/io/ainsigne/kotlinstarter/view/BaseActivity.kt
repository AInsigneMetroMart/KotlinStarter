package io.ainsigne.kotlinstarter.view

import android.content.Intent
import android.os.Bundle
import android.view.KeyEvent
import android.view.MenuItem
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import io.ainsigne.kotlinstarter.BuildConfig
import io.ainsigne.kotlinstarter.R
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinatorViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject

@Suppress("TooManyFunctions")
abstract class BaseActivity : AppCompatActivity(),
    CurrentScreenHook {

    // Replace this one with a custom back back icon
    var toolbarIcon: Int? = R.drawable.ic_back



    @Inject lateinit var currentScreenHookProvider: CurrentScreenHookProvider

    override fun onStart() {
        super.onStart()
        updateToolbar()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inject()
    }

    abstract fun inject()

    override fun onResume() {
        super.onResume()
        currentScreenHookProvider.currentScreenHook = this
    }

    fun updateHomeIcon(@DrawableRes iconRes: Int) {
        toolbarIcon = iconRes
        updateToolbar()
    }

    private fun updateToolbar() {
        supportActionBar?.also { actionBar ->
            actionBar.setDisplayHomeAsUpEnabled(true)
            toolbarIcon?.also { actionBar.setHomeAsUpIndicator(it) }
        }
    }

    override fun onPause() {
        super.onPause()
        currentScreenHookProvider.currentScreenHook = null
    }

    override fun finish() {
        super.finish()
    }

    override fun finishAffinity() {
        super.finishAffinity()
    }

    private val packageNameBase = "io.ainsigne"
    val shopId = "shop_id"
    val activityHome = "$packageNameBase.home.HomeActivity"
    val activityStores = "$packageNameBase.stores.StoresActivity"

    fun activity(): BaseActivity = this

    fun prepareIntent(
        activityClassName: String,
        bundle: Bundle? = null
    ): Intent {
        return Intent().apply {
            setClassName(BuildConfig.APPLICATION_ID, activityClassName)
            bundle?.also { putExtras(it) }
        }
    }

    override fun onNonRecoverableError(errorMessage: String) {
        if (BuildConfig.DEBUG) {
            // this is mostly to show something went wrong and was not handled correctly
            GlobalScope.launch(Dispatchers.Main) {
                MaterialAlertDialogBuilder(activity())
                    .setTitle("onNonRecoverableError")
                    .setMessage(errorMessage)
                    .setPositiveButton("ok") { _, _ ->
                        // nothing yet
                    }
                    .show()
            }
        }
    }

    override fun onUnAuthorizedError() {
        //appNavigator.openSessionExpired(activity())
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent): Boolean {
//        return when (keyCode) {
//            KeyEvent.KEYCODE_VOLUME_UP -> {
//
//            }
//            else -> super.onKeyUp(keyCode, event)
//        }
        return super.onKeyUp(keyCode, event)
    }

}
