package io.ainsigne.repository.shop

import io.ainsigne.repository.shop.model.Shop
import io.ainsigne.service.shop.ShopService
import io.ainsigne.utilities.Constants
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

/**
 * Repository implementation of [ShopRepository] interface
 * for making use of services to make an api call
 * and dao to cache the shop list response
 * @param shopService [ShopService] the service to call the api for shop related calls
 * @param shopsDao [ShopsDao] the dao for caching the shop list response
 */
class ShopRepositoryImpl(
    private val shopService: ShopService,
    private val shopsDao: ShopsDao
) : ShopRepository {

    /**
     * Populates the list of shops under an area id from cache
     * @param areaId of [String] area id to identify the list of shops returned
     * @return [Flow]<[List]<[Shop]>> the list of shops under an area id
     */
    override fun watchShops(areaId: String): Flow<List<Shop>> {
        return shopsDao.watchShops(areaId)
    }

    /**
     * Populates the shop identified by shop id from cache
     * @param shopId of [String] shop id to identify the shop returned
     * @return [Flow]<[Shop]> the shop with the shop id
     */
    override fun watchShop(shopId: String): Flow<Shop> {
        return shopsDao.watchShop(shopId)
    }

    /**
     * Refreshes the shops to be shop under an area id
     * @param areaId of [String] to identify the list of shops to cache
     * @return [Int] the number of shops returned
     */
    override suspend fun refreshShops(areaId: String): Int {
        val response =
            shopService.getShopsByAreaId(header = "Token ${Constants.token}", area_id = areaId)

        if(!response.isSuccessful)
            return 0
        return response.body()?.let { mResponse ->
            val shops = mResponse.data.mapNotNull {
                try {
                    val ids = it.relationships.active_fmcg_campaigns?.data?.map { it.id }
                    ids?.let {  ids ->
                        for(id in ids){
                            //Timber.d(" Shop has active ${it.attributes.name} $id ")
                        }
                    }
                    Shop(
                        id = it.id,
                        areaId = areaId,
                        bannerBackgroundColor = it.attributes.banner_background_color,
                        backgroundColor = it.attributes.background_color,
                        name = it.attributes.name,
                        locationName = it.attributes.location_name,
                        express = it.attributes.express,
                        logoPath = it.attributes.logo_path,
                        mobileBannerPath = it.attributes.mobile_banner_path,
                        priority = it.attributes.priority,
                        availableProductsCount = it.attributes.available_products_count,
                        productsOnSaleCount = it.attributes.products_on_sale_count,
                        newArrivalsCount = it.attributes.new_arrival_products_count,
                        popularProductsCount = it.attributes.popular_products_count,
                        buyXTakeYProductsCount = it.attributes.products_with_buy_x_take_y_count,
                        nextDeliveryPhrase = it.attributes.next_delivery_phrase,
                        nextDeliveryFrom = it.attributes.next_delivery_from,
                        activeFMCGCampaignIds = ids ?: emptyList(),
                        activeFMCGCampaigns = emptyList(),
                        departments = it.relationships.departments.toString()
                    )
                } catch (exception: Exception) {
                    null
                }
            }
            shopsDao.insertShops(shops)
            shops.count()
        } ?: 0
    }

}