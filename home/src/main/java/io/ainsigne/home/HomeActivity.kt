package io.ainsigne.home

import android.os.Bundle
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.ainsigne.home.databinding.ActivityHomeBinding
import io.ainsigne.kotlinstarter.injection.app.InjectUtils

import io.ainsigne.kotlinstarter.view.BaseActivity
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinator
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinatorViewModel
import javax.inject.Inject


class HomeActivity : BaseActivity(){
    private lateinit var binding: ActivityHomeBinding

    @Inject
    lateinit var viewmodel: HomeViewModel

    val navigationViewModel = NavigationCoordinatorViewModel()

    private fun observeNavigation() {
        navigationViewModel.navigation.observe(this) { navigation ->
            if (navigation == null) return@observe

            when(navigation) {
                is NavigationCoordinator.PopBackStack -> navController.popBackStack()
                is NavigationCoordinator.NavigateUp -> navController.navigateUp()
                is NavigationCoordinator.PopBackStackSpecific -> { navController.popBackStack(navigation.destinationId, navigation.inclusive) }
                else -> navigation.navDirections?.also { navController.navigate(it) }
            }
        }
    }
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        navController = findNavController(R.id.nav_host_fragment_activity_home)
        binding.navView.setupWithNavController(navController)

        observeNavigation()
//        intent.extras?.getString(shop_id)?.let {
//            navController.addOnDestinationChangedListener { _, destination, arguments ->
//                val argument = NavArgument.Builder().setDefaultValue(it).build()
//                destination.addArgument(shop_id, argument)
//            }
//        }


    }

    override fun inject() {
        DaggerHomeComponent.builder()
            .appComponent(InjectUtils.getComponent(applicationContext))
            .homeModule(HomeComponent.HomeModule(this))
            .build()
            .inject(this)
    }


}