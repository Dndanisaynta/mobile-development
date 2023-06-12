package com.captsone.pantura.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.captsone.pantura.databinding.CardLaporanBinding
import com.captsone.pantura.model.Laporan

class RecyclerViewAdapter(
    private var dataList: List<Laporan>,
    private val onClickListener: (Laporan) -> Unit
) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CardLaporanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = dataList[position]
        holder.bind(item)
        holder.itemView.setOnClickListener {
            onClickListener(item)
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    fun updateData(newDataList: List<Laporan>) {
        dataList = newDataList
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: CardLaporanBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Laporan) {
            binding.dateCard.text = item.tanggal
            binding.cardLocation.text = item.location
            binding.cardDescription.text = item.deskripsi
        }
    }
}
