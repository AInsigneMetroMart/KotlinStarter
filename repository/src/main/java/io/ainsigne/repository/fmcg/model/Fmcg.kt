package io.ainsigne.repository.fmcg.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "fmcg_campaigns")
data class Fmcg(@PrimaryKey val id: String,
                @ColumnInfo(name = "areaId") val areaId: String,
                @ColumnInfo(name = "name") val name: String,
                @ColumnInfo(name = "kind") val kind: FMCGKind,
                @ColumnInfo(name = "mobile-shop-in-shop-banner-path") val mobileSISBannerPath: String?,
                @ColumnInfo(name = "mobile-icon-path") val mobileIconPath: String?)
