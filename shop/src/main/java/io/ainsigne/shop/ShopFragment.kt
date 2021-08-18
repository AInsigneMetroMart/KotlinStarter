package io.ainsigne.shop

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import io.ainsigne.kotlinstarter.injection.app.InjectUtils
import io.ainsigne.kotlinstarter.view.BaseActivity
import io.ainsigne.kotlinstarter.view.BaseFragment
import io.ainsigne.kotlinstarter.view.helper.viewBinding
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinator
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinatorViewModel
import io.ainsigne.shop.databinding.FragmentShopBinding
import io.ainsigne.utilities.Constants
import timber.log.Timber
import javax.inject.Inject

class ShopFragment : BaseFragment(R.layout.fragment_shop) {

    private val binding: FragmentShopBinding by viewBinding(FragmentShopBinding::bind)

    @Inject lateinit var viewModel: ShopViewModel
    val navigationViewModel = NavigationCoordinatorViewModel()
    val IMAGE_BOSS_DOMAIN = "https://img.imageboss.me"

    val IMAGE_BOSS_TOKEN = "?bossToken="
    val IMAGE_BOSS_URL = "/metromart-staging/width/"
    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        binding
            .apply {
                viewModel = this@ShopFragment.viewModel
                lifecycleOwner = viewLifecycleOwner

            }
        binding.ivStore.setOnClickListener {
            navigationViewModel.shopToShopSample()
        }
        with(viewModel) {
            item.observe(viewLifecycleOwner, {
                binding.tvStore.text = it.name
                val imageHeight: String = IMAGE_BOSS_URL + 740
                val image = IMAGE_BOSS_DOMAIN  + imageHeight + it.logoPath
                Glide.with(activity()).load(image).into(binding.ivStore)
            })
        }
    }

    override fun onAttach(context: Context) {
        DaggerShopComponent.builder()
            .appComponent(InjectUtils.getComponent(activity().applicationContext))
            .shopModule(ShopComponent.ShopModule(activity(),activity().intent.extras?.getString("shop-id").toString()))
            .build()
            .inject(this)

        super.onAttach(context)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }
}