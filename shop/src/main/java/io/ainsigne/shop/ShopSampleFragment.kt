package io.ainsigne.shop

import android.content.Context
import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import io.ainsigne.kotlinstarter.injection.app.InjectUtils
import io.ainsigne.kotlinstarter.view.BaseFragment
import io.ainsigne.kotlinstarter.view.helper.viewBinding
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinator
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinatorViewModel
import io.ainsigne.shop.databinding.FragmentShopBinding
import io.ainsigne.utilities.Constants
import timber.log.Timber
import javax.inject.Inject

class ShopSampleFragment : BaseFragment(R.layout.fragment_shop) {

    private val binding: FragmentShopBinding by viewBinding(FragmentShopBinding::bind)



    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding
            .apply {
                lifecycleOwner = viewLifecycleOwner

            }

    }

    override fun onAttach(context: Context) {


        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}