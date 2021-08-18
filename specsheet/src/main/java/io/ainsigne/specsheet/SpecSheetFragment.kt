package io.ainsigne.specsheet

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import io.ainsigne.kotlinstarter.view.BaseFragment
import io.ainsigne.kotlinstarter.view.helper.viewBinding
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinator
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinatorViewModel
import io.ainsigne.specsheet.databinding.FragmentSpecSheetBinding


class SpecSheetFragment : BaseFragment(R.layout.fragment_spec_sheet) {
    val navigationViewModel = NavigationCoordinatorViewModel()
    private val binding: FragmentSpecSheetBinding by viewBinding(FragmentSpecSheetBinding::bind)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnButtons.setOnClickListener {
            navigationViewModel.specSheetToSpec("Buttons")
        }
        binding.btnTypo.setOnClickListener {
            navigationViewModel.specSheetToSpec("Typo")
        }
        binding.btnColors.setOnClickListener {
            navigationViewModel.specSheetToSpec("Colors")
        }
        binding.btnWidget.setOnClickListener {
            navigationViewModel.specSheetToSpec("Widget")
        }
        binding.btnForm.setOnClickListener {
            navigationViewModel.specSheetToSpec("Form")
        }
        observeNavigation()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    private fun observeNavigation() {
        navigationViewModel.navigation.observe(viewLifecycleOwner) { navigation ->
            if (navigation == null) return@observe

            when(navigation) {
                is NavigationCoordinator.PopBackStack -> findNavController().popBackStack()
                is NavigationCoordinator.NavigateUp -> findNavController().navigateUp()
                is NavigationCoordinator.PopBackStackSpecific -> { findNavController().popBackStack(navigation.destinationId, navigation.inclusive) }
                else -> navigation.navDirections?.also { findNavController().navigate(it) }
            }
        }
    }



}