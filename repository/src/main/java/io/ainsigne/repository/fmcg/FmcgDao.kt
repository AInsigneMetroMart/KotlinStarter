package io.ainsigne.repository.fmcg

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.ainsigne.repository.fmcg.model.Fmcg
import kotlinx.coroutines.flow.Flow

@Dao
interface FmcgDao {
    @Query("SELECT * from fmcg_campaigns WHERE areaId == :areaId")
    fun watchFmcgs(areaId: String): Flow<List<Fmcg>>

    @Query("SELECT * from fmcg_campaigns WHERE id == :fmcgId")
    fun watchFmcg(fmcgId: String): Flow<Fmcg>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFmcg(fmcg: Fmcg)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFmcgs(shops: List<Fmcg>)

    @Query("DELETE FROM fmcg_campaigns WHERE id = :fmcgId")
    suspend fun deleteFmcg(fmcgId: String)

}