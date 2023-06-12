package com.captsone.pantura.model

data class Laporan(
    val tanggal: String,
    val location: String,
    val deskripsi: String,
    val foto: String
)

data class Profile(
    val nama: String,
    val email: String
)