package io.ainsigne.kotlinstarter.feature.progress

import androidx.fragment.app.FragmentManager

class LazyProgressDialog {
    private var progressDialog: ProgressDialogFragment? = null

    fun setVisibility(show: Boolean, fragmentManager: FragmentManager) {
        when (show) {
            true -> {
                if (progressDialog == null) progressDialog = ProgressDialogFragment()
                progressDialog?.also { dialog ->
                    if (!dialog.isVisible) dialog.show(fragmentManager, null)
                }
            }
            false -> progressDialog?.dismiss()
        }
    }
}
