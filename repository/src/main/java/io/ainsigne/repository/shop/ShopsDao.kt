package io.ainsigne.repository.shop

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ainsigne.repository.shop.model.Shop
import kotlinx.coroutines.flow.Flow

@Dao
interface ShopsDao {
    @Query("SELECT * from shop WHERE areaId == :areaId")
    fun watchShops(areaId: String): Flow<List<Shop>>

    @Query("SELECT * from shop WHERE id == :shopId")
    fun watchShop(shopId: String): Flow<Shop>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShop(shop: Shop)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShops(shops: List<Shop>)

    @Query("DELETE FROM shop WHERE id = :shopId")
    suspend fun deleteShop(shopId: String)

}