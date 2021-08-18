package io.ainsigne.repository.model

import io.ainsigne.repository.fmcg.FmcgRepository
import io.ainsigne.repository.fmcg.model.FMCGKind
import io.ainsigne.repository.fmcg.model.Fmcg
import io.ainsigne.service.AttributesBase
import io.ainsigne.service.Entity
import io.ainsigne.service.Relationships
import io.ainsigne.utilities.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import java.lang.Exception

class FakeFmcgRepositoryImpl : FmcgRepository {
    override fun watchFmcgs(areaId: String): Flow<List<Fmcg>> {
        val response = ArrayList<Entity>()
        val relationships = Relationships()
        for (i in 0 until 4){
            response.add(
                Entity(attributes = getAttributes(i),
                    relationships = relationships,
                    id = fakeIds[i], type = "fmcg-campaigns")
            )
        }
        val fmcgs = response.mapNotNull {
            try {
                Fmcg(
                    id = it.id,
                    areaId = areaId,
                    name = it.attributes.name.toString(),
                    kind = FMCGKind.FREE_DELIVERY,
                    mobileSISBannerPath = it.attributes.mobile_banner_path,
                    mobileIconPath = it.attributes.mobile_shop_in_shop_banner_path
                )
            } catch (exception : Exception){
                null
            }
        }
        return flowOf(fmcgs)
    }

    val fakeCampaigns = arrayOf("froneri","selecta","coca cola","magnolia")
    val fakeIds = arrayOf("21","22","23","24")

    private fun getAttributes(position: Int) : AttributesBase{
        val attributesBase = AttributesBase()
        attributesBase.name = fakeCampaigns[position]
        attributesBase.kind = "free-delivery"
        attributesBase.mobile_banner_path = ""
        attributesBase.mobile_shop_in_shop_banner_path = ""
        return attributesBase
    }



    override fun watchFmcg(fmcgId: String): Flow<Fmcg> {
        return flowOf(Fmcg(id = "1", "21","FRONERI",FMCGKind. FREE_DELIVERY,
            "",""))
    }

    override suspend fun refreshFmcgs(areaId: String): Int {
        return 1
    }
}