package com.captsone.pantura.network.repository

import com.captsone.pantura.model.Laporan
import com.captsone.pantura.util.Util.listDummyData

interface LaporanRepository {
    suspend fun getData(): List<Laporan>
}