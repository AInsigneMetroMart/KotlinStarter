package io.ainsigne.kotlinstarter.view

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

open class BaseFragment(layoutRes: Int) : Fragment(layoutRes) {

    fun activity(): FragmentActivity = requireActivity()

}
