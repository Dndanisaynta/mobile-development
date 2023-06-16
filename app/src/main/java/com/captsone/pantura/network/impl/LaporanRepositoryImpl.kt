package com.captsone.pantura.network.impl

import com.captsone.pantura.model.Laporan
import com.captsone.pantura.network.repository.LaporanRepository
import com.captsone.pantura.util.Util
import com.captsone.pantura.util.Util.listDummyData
import javax.inject.Inject

class LaporanRepositoryImpl @Inject constructor(

): LaporanRepository {
    override suspend fun getData(): List<Laporan> {
        return listDummyData
    }

}