package io.ainsigne.repository.fmcg

import io.ainsigne.repository.fmcg.model.Fmcg
import kotlinx.coroutines.flow.Flow


interface FmcgRepository {

    fun watchFmcgs(areaId: String): Flow<List<Fmcg>>

    fun watchFmcg(fmcgId: String): Flow<Fmcg>

    suspend fun refreshFmcgs(areaId: String): Int
}