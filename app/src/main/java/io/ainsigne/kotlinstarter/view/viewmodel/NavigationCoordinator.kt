package io.ainsigne.kotlinstarter.view.viewmodel

import androidx.annotation.IdRes
import androidx.navigation.NavDirections
import io.ainsigne.shop.ShopFragmentDirections
import io.ainsigne.specsheet.SpecSheetFragmentDirections

sealed class NavigationCoordinator(val navDirections: NavDirections? = null) {
    object PopBackStack : NavigationCoordinator()

    object NavigateUp : NavigationCoordinator()

    data class PopBackStackSpecific(@IdRes val destinationId: Int, val inclusive: Boolean = false) :
        NavigationCoordinator()

    object ShopToShopSample :
        NavigationCoordinator(ShopFragmentDirections.actionShopToShopSample())

    data class SpecSheetToSpec(val spec: String) :
        NavigationCoordinator(SpecSheetFragmentDirections.actionSpecsheetToSpec(spec))

}
