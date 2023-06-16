package com.captsone.pantura.view.base.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.captsone.pantura.model.Laporan
import com.captsone.pantura.network.impl.LaporanRepositoryImpl
import com.captsone.pantura.network.repository.LaporanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val laporanRepositoryImpl: LaporanRepositoryImpl
) : ViewModel() {
    private val _dataLaporan = MutableLiveData<List<Laporan>>()
    val dataLaporan: LiveData<List<Laporan>> = _dataLaporan

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            _dataLaporan.value = laporanRepositoryImpl.getData()
        }
    }
}