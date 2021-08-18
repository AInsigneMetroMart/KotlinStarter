package io.ainsigne.repository.converter

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.ainsigne.repository.fmcg.FmcgDao
import io.ainsigne.repository.fmcg.model.Fmcg
import io.ainsigne.repository.room.converter.BigDecimalConverters
import io.ainsigne.repository.room.converter.DateConverters
import io.ainsigne.repository.room.converter.GsonConverter
import io.ainsigne.repository.shop.ShopsDao
import io.ainsigne.repository.shop.model.Shop

@Database(
    entities =
    [
        Shop::class,
        Fmcg::class
    ],
    version = 29,
    exportSchema = false
)
@TypeConverters(
    DateConverters::class,
    BigDecimalConverters::class,
    GsonConverter::class
)
abstract class AiDatabase : RoomDatabase() {

    abstract fun shopsDao(): ShopsDao
    abstract fun fmcgDao(): FmcgDao

    companion object {

        fun getInstance(context: Context): AiDatabase = buildDatabase(context)

        private fun buildDatabase(context: Context) =
            Room
                .databaseBuilder(
                    context.applicationContext,
                    AiDatabase::class.java,
                    "ai.db"
                )
                .fallbackToDestructiveMigration()
                .build()
    }
}