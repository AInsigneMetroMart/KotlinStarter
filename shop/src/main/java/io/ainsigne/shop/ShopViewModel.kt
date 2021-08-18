package io.ainsigne.shop

import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.analytics.AnalyticsScreen
import io.ainsigne.kotlinstarter.view.viewmodel.BaseViewModel
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import io.ainsigne.kotlinstarter.view.viewmodel.LiveDataChange
import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.shop.ShopRepository
import io.ainsigne.repository.shop.model.Shop
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ShopViewModel(private val coroutineContextProvider: CoroutineContextProvider,
                    private val analytics: AnalyticsClient,
                    val fmcgRepository: FmcgRepository,
                    val shopRepository: ShopRepository,
                    val shopId: String) : BaseViewModel(coroutineContextProvider) {


    data class Data(
        val shopId: String? = null,
        val shop: Shop? = null
    )

    private val dataChange = LiveDataChange(
        Data(
            shopId = shopId,
            shop = null
        )
    )


    val item = dataChange
        .get()
        .asFlow()
        .flatMapLatest { shopRepository.watchShop(shopId) }
        .asLiveData()


    init {
        analytics.screenView(AnalyticsScreen("shops"))
        ioScope.launch {
            dataChange.get()
                .asFlow()
                .map { it.shopId }
                .distinctUntilChanged()
                .flatMapLatest { shopRepository.watchShop(shopId) }
                .collect { dataChange.update { copy(shop = it) } }
        }

        // May need to refresh
    }

}