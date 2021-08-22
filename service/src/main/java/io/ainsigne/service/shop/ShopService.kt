package io.ainsigne.service.shop

import io.ainsigne.service.MultiEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Shop service for making api calls that are shop related
 */
interface ShopService {

    data class Filter(
        val areaId: String,

        )

    /**
     * Retrieves list of shops from the api through its area id
     * @param header - [String] Authorization token
     * @param area_id - [String] area id to retrieve the shops with
     * @return [Response]<[MultiEntityResponse]>
     */
    @GET("shops")
    suspend fun getShopsByAreaId(
        @Header("Authorization") header: String?,
        @Query("filter[area.id]") area_id: String?
    ): Response<MultiEntityResponse>

    /**
     * Retrieves shop from the api through its id
     * @param header - [String] Authorization token
     * @param shop_id - [String] shop id to retrieve the shop with
     * @return [Response]<[MultiEntityResponse]>
     */
    @Headers("X-Client-Platform: Android", "X-Client-Version: 94")
    @GET("shops")
    fun getShopsById(
        @Header("Authorization") header: String?,
        @Query("filter[id]") shop_id: String?,
        @Query("sort") sort: String?
    ): Response<MultiEntityResponse>


}