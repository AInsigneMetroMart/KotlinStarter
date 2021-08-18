package io.ainsigne.service.departments

import io.ainsigne.service.MultiEntityResponse
import io.ainsigne.service.SingleEntityResponse
import retrofit2.Call
import retrofit2.http.*

interface DepartmentService {
    @Headers("X-Client-Platform: Android", "X-Client-Version: 94")
    @GET("departments")
    fun getDepartmentsByShopId(
        @Header("Authorization") header: String?,
        @Query("filter[shop-id]") shop_id: String?,
        @Query("include") include: String?
    ): Call<MultiEntityResponse?>?

    @Headers("X-Client-Platform: Android", "X-Client-Version: 94")
    @GET("departments/{id}")
    fun get_department_with_aisles_by_id(
        @Header("Authorization") header: String?,
        @Path("id") id: String?,
        @Query("include") include: String?
    ): Call<SingleEntityResponse?>?
}