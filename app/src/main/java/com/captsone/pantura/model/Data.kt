package com.captsone.pantura.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Laporan(
    val tanggal: String,
    val location: String,
    val deskripsi: String,
    val foto: String,
    val tingkat: String,
    val keterangan: String,
    val statusLaporan: String,
    val statusPenanganan: String
): Parcelable

data class Profile(
    val nama: String,
    val email: String
)