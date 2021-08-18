package io.ainsigne.service.shop


import io.ainsigne.service.Entity
import io.ainsigne.service.MultiEntityResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ShopService {

    data class Filter(
        val areaId: String,

        )

    @GET("shops")
    suspend fun getShopsByAreaId(
        @Header("Authorization") header: String?,
        @Query("filter[area.id]") area_id: String?
    ): Response<MultiEntityResponse>

    @Headers("X-Client-Platform: Android", "X-Client-Version: 94")
    @GET("shops")
    fun getShopsById(
        @Header("Authorization") header: String?,
        @Query("filter[id]") shop_id: String?,
        @Query("sort") sort: String?
    ): Response<MultiEntityResponse>


}