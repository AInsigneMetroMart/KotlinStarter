package io.ainsigne.service.products

import io.ainsigne.service.MultiEntityResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface ProductService {
    @Headers("X-Client-Platform: Android", "X-Client-Version: 86")
    @GET("search/products")
    fun getProductByName(
        @Header("Authorization") header: String?,
        @Query("filter[shop.id]") shop_id: String?,
        @Query("filter[keyword]") name: String?,
        @Query("filter[status]") status: String?,
        @Query("sort") sort: String?,
        @Query("include") include: String?,
        @Query("page[number]") page: String?,
        @Query("page[size]") size: String?
    ): Call<MultiEntityResponse?>?
}