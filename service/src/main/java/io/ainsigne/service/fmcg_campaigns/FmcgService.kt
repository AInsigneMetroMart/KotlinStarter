package io.ainsigne.service.fmcg_campaigns

import io.ainsigne.service.MultiEntityResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface FmcgService {

    data class Filter(
        val areaId: String,

        )

    @GET("fmcg-campaigns")
    suspend fun getFMCGsByAreaId(
        @Header("Authorization") header: String?,
        @Query("filter[area.id]") area_id: String?,
        @Query("filter[active]") active: Boolean
    ): Response<MultiEntityResponse>


}