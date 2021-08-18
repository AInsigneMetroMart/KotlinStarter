package io.ainsigne.kotlinstarter.feature.progress

import android.app.Dialog
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.KeyEvent
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import io.ainsigne.kotlinstarter.R
import io.ainsigne.kotlinstarter.databinding.FragmentProgressDialogBinding

class ProgressDialogFragment : DialogFragment() {

    private lateinit var binding: FragmentProgressDialogBinding

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val rootView = getRootView()

        val dialog = AlertDialog
            .Builder(requireActivity())
            .setCancelable(false)
            .setView(rootView)
            .create()

        dialog.setCanceledOnTouchOutside(false)
        dialog.setOnKeyListener { _, keyCode, _ -> keyCode == KeyEvent.KEYCODE_BACK }
        val progressView = binding.progressView
        progressView.layoutParams =
            FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT)
        dialog.window?.apply {
            setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(requireContext(), R.color.transparent)))

            addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            //solves issue with statusbar
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            setGravity(Gravity.CENTER)
        }

        return dialog
    }

    private fun getRootView(): View {
        binding = FragmentProgressDialogBinding.inflate(requireActivity().layoutInflater, null, false)
        val progressView = binding.progressView
        progressView.show()
        return binding.root
    }
}
