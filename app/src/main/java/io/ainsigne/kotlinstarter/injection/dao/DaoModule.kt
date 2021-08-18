package io.ainsigne.kotlinstarter.injection.dao

import android.content.Context
import dagger.Module
import dagger.Provides
import io.ainsigne.repository.converter.AiDatabase
import io.ainsigne.repository.fmcg.FmcgDao
import io.ainsigne.repository.shop.ShopsDao
import javax.inject.Singleton


@Module
class DaoModule {

    @Provides
    @Singleton
    fun provideDatabase(context: Context): AiDatabase {
        return AiDatabase.getInstance(context)
    }

    @Provides
    fun getShopsDao(db: AiDatabase): ShopsDao {
        return db.shopsDao()
    }

    @Provides
    fun getFmcgsDao(db: AiDatabase): FmcgDao {
        return db.fmcgDao()
    }

}
