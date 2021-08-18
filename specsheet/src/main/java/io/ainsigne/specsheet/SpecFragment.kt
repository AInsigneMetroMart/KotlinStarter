package io.ainsigne.specsheet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.ainsigne.kotlinstarter.view.BaseFragment
import io.ainsigne.kotlinstarter.view.helper.viewBinding
import io.ainsigne.specsheet.databinding.FragmentSpecBinding
import io.ainsigne.specsheet.databinding.FragmentSpecSheetBinding


class SpecFragment : BaseFragment(R.layout.fragment_spec) {

    private val binding: FragmentSpecBinding by viewBinding(FragmentSpecBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.getString("spec")?.let {
            binding.containerButtons.root.visibility = View.GONE
            binding.containerColors.root.visibility = View.GONE
            binding.containerForm.root.visibility = View.GONE
            binding.containerTypo.root.visibility = View.GONE
            binding.containerWidget.root.visibility = View.GONE
            if(it == "Buttons") {
                binding.containerButtons.root.visibility = View.VISIBLE
            }else if(it == "Colors") {
                binding.containerColors.root.visibility = View.VISIBLE
            }else if(it == "Typo") {
                binding.containerTypo.root.visibility = View.VISIBLE
            }else if(it == "Widget") {
                binding.containerWidget.root.visibility = View.VISIBLE
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }



}