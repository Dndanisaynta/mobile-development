package com.captsone.pantura.view.edit

import android.os.Bundle
import android.text.Editable
import android.text.SpannableStringBuilder
import androidx.appcompat.app.AppCompatActivity
import com.captsone.pantura.databinding.ActivityEditBinding
import com.captsone.pantura.model.Laporan
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EditActivity : AppCompatActivity() {
    private lateinit var binding: ActivityEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.getParcelableExtra<Laporan>("dataLaporan")
        if (data != null) {

            binding.inputAlamat.text = stringTextBuilder(data.location)
            binding.inputTanggal.text = stringTextBuilder(data.tanggal)
            binding.inputKeterangan.text = stringTextBuilder(data.keterangan)

            binding.laporanLapor.text = data.statusLaporan
            binding.laporanPenanganan.text = data.statusPenanganan
            binding.laporanKerusakan.text = data.tingkat
        }
        binding.topAppBar.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    private fun stringTextBuilder(p0: String): Editable {
        return SpannableStringBuilder(p0)
    }
}