package io.ainsigne.kotlinstarter

import androidx.annotation.IdRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import io.ainsigne.kotlinstarter.view.livedata.SingleLiveEvent
import io.ainsigne.kotlinstarter.view.viewmodel.NavigationCoordinator


class FakeNavigationCoordinatorViewModel : ViewModel(){
    private val _navigation = SingleLiveEvent<NavigationCoordinator?>(null)
    val navigation: LiveData<NavigationCoordinator?> = _navigation

    fun shopToShopSample() {
       _navigation.value = NavigationCoordinator.ShopToShopSample
    }


    fun specSheetToSpec(spec: String) {
        _navigation.value = NavigationCoordinator.SpecSheetToSpec(spec)
    }

    fun popBackStack() {
        _navigation.value = NavigationCoordinator.PopBackStack
    }

    fun popBackStack(@IdRes destinationId: Int, inclusive: Boolean = false) {
        _navigation.value = NavigationCoordinator.PopBackStackSpecific(destinationId, inclusive)
    }

    fun navigateUp() {
        _navigation.value = NavigationCoordinator.NavigateUp
    }

}