package io.ainsigne.stores

import androidx.lifecycle.asFlow
import androidx.lifecycle.asLiveData
import io.ainsigne.analytics.AnalyticsClient
import io.ainsigne.analytics.AnalyticsScreen
import io.ainsigne.kotlinstarter.view.viewmodel.BaseViewModel
import io.ainsigne.kotlinstarter.view.viewmodel.CoroutineContextProvider
import io.ainsigne.kotlinstarter.view.viewmodel.LiveDataChange
import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.fmcg.model.Fmcg
import io.ainsigne.repository.shop.ShopRepository
import io.ainsigne.repository.shop.model.Shop
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber

class StoresViewModel(private val coroutineContextProvider: CoroutineContextProvider,
                      private val analytics: AnalyticsClient,
                      val fmcgRepository: FmcgRepository,
                      val shopRepository: ShopRepository,
                      val areaId: String) : BaseViewModel(coroutineContextProvider) {


    data class Data(
        val areaId: String? = null,
        val shops: List<Shop>? = null,
        val fmcgs: List<Fmcg>? = null
    )

    private val dataChange = LiveDataChange(
        Data(
            areaId = areaId,
            shops = null,
            fmcgs = null
        )
    )

    val shops = dataChange
        .get()
        .asFlow()
        .flatMapLatest { shopRepository.watchShops(areaId) }

    val fmcgs = dataChange
        .get()
        .asFlow()
        .flatMapLatest { fmcgRepository.watchFmcgs(areaId) }

    val items = dataChange
        .get()
        .asFlow()
        .flatMapLatest { shopRepository.watchShops(areaId) }
        .asLiveData()

    val exposed = dataChange.get().asFlow().flatMapLatest {
        shops
    }.asLiveData()


    init {
        analytics.screenView(AnalyticsScreen("shops"))

        ioScope.launch {
            dataChange.get()
                .asFlow()
                .map { it.areaId }
                .distinctUntilChanged()
                .flatMapLatest { shopRepository.watchShops(areaId) }
                .collect { dataChange.update { copy(shops = it) } }
        }

        ioScope.launch {
            dataChange.get()
                .asFlow()
                .map { it.areaId }
                .distinctUntilChanged()
                .flatMapLatest { fmcgRepository.watchFmcgs(areaId) }
                .collect { dataChange.update { copy(fmcgs = it) } }
        }

        ioScope.launch {
            dataChange.get()
                .asFlow()
                .map { it.areaId }
                .distinctUntilChanged()
                .collect {
                    shopRepository.refreshShops(areaId)
                }

        }

        ioScope.launch {
            dataChange.get()
                .asFlow()
                .map { it.areaId }
                .distinctUntilChanged()
                .collect {
                    fmcgRepository.refreshFmcgs(areaId)
                }
        }

        ioScope.launch {
            shops.combine(fmcgs){ shoplist,fmcglist ->
                shoplist.map { shop ->
                    shop.activeFMCGCampaignIds.let {  ids ->
                        val filtered = fmcglist.filter {
                                fmcg -> ids.contains(fmcg.id)
                        }
                        shop.activeFMCGCampaigns = filtered
                    }
                    shop
                }
            }.collect{

            }
        }


    }

}