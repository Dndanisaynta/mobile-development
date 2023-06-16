package com.captsone.pantura.view.base.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.captsone.pantura.R
import com.captsone.pantura.databinding.ActivityDetailBinding
import com.captsone.pantura.model.Laporan
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)

        val data = intent.getParcelableExtra<Laporan>("dataLaporan")
        if (data != null){
            binding.laporanKerusakan.text = data.tingkat
            binding.laporanKeterangan.text = data.keterangan
            binding.laporanLapor.text = data.statusLaporan
            binding.laporanPenanganan.text = data.statusPenanganan
            binding.laporanTanggal.text = data.tanggal
            binding.laporanLokasi.text = data.location
        }
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
        setContentView(binding.root)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}