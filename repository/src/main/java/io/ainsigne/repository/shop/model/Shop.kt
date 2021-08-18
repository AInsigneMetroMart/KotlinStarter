package io.ainsigne.repository.shop.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import io.ainsigne.repository.fmcg.model.Fmcg

@Entity(tableName = "shop")
data class Shop(@PrimaryKey val id: String,
                @ColumnInfo(name = "areaId") val areaId: String,
                @ColumnInfo(name = "bannerBackgroundColor") val bannerBackgroundColor: String?,
                @ColumnInfo(name = "backgroundColor") val backgroundColor: String?,
                @ColumnInfo(name = "name") val name: String?,
                @ColumnInfo(name = "locationName") val locationName: String?,
                @ColumnInfo(name = "express") val express: Boolean,
                @ColumnInfo(name = "logoPath") val logoPath: String?,
                @ColumnInfo(name = "mobileBannerPath") val mobileBannerPath: String?,
                @ColumnInfo(name = "priority") val priority: Int,
                @ColumnInfo(name = "availableProductsCount") val availableProductsCount: Int,
                @ColumnInfo(name = "productsOnSaleCount") val productsOnSaleCount: Int,
                @ColumnInfo(name = "newArrivalsCount") val newArrivalsCount: Int,
                @ColumnInfo(name = "popularProductsCount") val popularProductsCount: Int,
                @ColumnInfo(name = "buyXTakeYProductsCount") val buyXTakeYProductsCount: Int,
                @ColumnInfo(name = "nextDeliveryPhrase") val nextDeliveryPhrase: String?,
                @ColumnInfo(name = "nextDeliveryFrom") val nextDeliveryFrom: String?,
                @ColumnInfo(name = "activeFMCGCampaignIds") val activeFMCGCampaignIds: List<String>,
                @ColumnInfo(name = "activeFMCGCampaigns") var activeFMCGCampaigns: List<Fmcg>,
                @ColumnInfo(name = "departments") val departments: String)
