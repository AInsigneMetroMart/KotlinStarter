package io.ainsigne.repository.fmcg


import io.ainsigne.repository.fmcg.model.FMCGKind
import io.ainsigne.repository.fmcg.model.Fmcg
import io.ainsigne.service.fmcg_campaigns.FmcgService
import io.ainsigne.utilities.Constants
import kotlinx.coroutines.flow.Flow
import java.lang.Exception

class FmcgRepositoryImpl(
    private val fmcgService: FmcgService,
    private val fmcgDao: FmcgDao
) : FmcgRepository {
    override fun watchFmcgs(areaId: String): Flow<List<Fmcg>> {
        return fmcgDao.watchFmcgs(areaId)
    }

    override fun watchFmcg(fmcgId: String): Flow<Fmcg> {
        return fmcgDao.watchFmcg(fmcgId)
    }

    override suspend fun refreshFmcgs(areaId: String): Int {
        val response = fmcgService.getFMCGsByAreaId(header = "Token ${Constants.token}", area_id = areaId, active = true)
        if(!response.isSuccessful)
            return 0
        return response.body()?.let { mResponse ->
            val fmcgs = mResponse.data.mapNotNull {
                try {
                    Fmcg(
                        it.id,
                        areaId,
                        it.attributes.name.toString(),
                        convertToKind(it.attributes.kind.toString()),
                        it.attributes.mobile_shop_in_shop_banner_path,
                        it.attributes.mobile_icon_path
                    )
                } catch (exception : Exception){
                    null
                }
            }
            fmcgDao.insertFmcgs(fmcgs)
            fmcgs.count()
        } ?: 0
    }

    private fun convertToKind(kind: String) : FMCGKind{
        if(kind == "peso-discount")
            return FMCGKind.PESO_DISCOUNT
        else if(kind == "free-delivery")
            return FMCGKind.FREE_DELIVERY
        else
            return FMCGKind.DISPLAY_ONLY
    }
}