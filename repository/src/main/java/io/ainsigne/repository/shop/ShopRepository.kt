package io.ainsigne.repository.shop


import io.ainsigne.repository.shop.model.Shop
import kotlinx.coroutines.flow.Flow


interface ShopRepository {

    fun watchShops(areaId: String): Flow<List<Shop>>

    fun watchShop(shopId: String): Flow<Shop>

    suspend fun refreshShops(areaId: String): Int
}