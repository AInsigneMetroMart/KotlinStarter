package io.ainsigne.repository.shop

import io.ainsigne.repository.shop.model.Shop
import kotlinx.coroutines.flow.Flow

interface ShopRepository {

    /**
     * Populates the list of shops under an area id from cache
     * @param areaId of [String] area id to identify the list of shops returned
     * @return [Flow]<[List]<[Shop]>> the list of shops under an area id
     */
    fun watchShops(areaId: String): Flow<List<Shop>>

    /**
     * Populates the shop identified by shop id from cache
     * @param shopId of [String] shop id to identify the shop returned
     * @return [Flow]<[Shop]> the shop with the shop id
     */
    fun watchShop(shopId: String): Flow<Shop>

    /**
     * Refreshes the shops to be shop under an area id
     * @param areaId of [String] to identify the list of shops to cache
     * @return [Int] the number of shops returned
     */
    suspend fun refreshShops(areaId: String): Int
}