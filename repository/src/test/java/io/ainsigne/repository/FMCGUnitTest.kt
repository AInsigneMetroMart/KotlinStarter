package io.ainsigne.repository

import io.ainsigne.repository.model.FakeFmcgRepositoryImpl
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Test

class FMCGUnitTest {
    val fakeRepo = FakeFmcgRepositoryImpl()
    @Test
    fun testFMCGRepo() = runBlocking{
        fakeRepo.watchFmcgs(areaId = "21").collect {
            assert(it.find { fmcg -> fmcg.id == "21" } != null)
        }

    }


}