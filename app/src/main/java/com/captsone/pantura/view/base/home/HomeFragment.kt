package com.captsone.pantura.view.base.home

import android.content.Intent
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.captsone.pantura.R
import com.captsone.pantura.adapter.RecyclerViewAdapter
import com.captsone.pantura.databinding.FragmentHomeBinding
import com.captsone.pantura.model.Laporan
import com.captsone.pantura.view.base.detail.DetailActivity
import com.captsone.pantura.view.edit.EditActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var viewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerAdapter: RecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        recyclerAdapter = RecyclerViewAdapter(listOf<Laporan>(), {
            onDetailClicked(it)
        }, {
             onEditButtonClicked(it)
        }, {
            onDeleteButtonClicked(it)
        })
        binding.recyclerView.layoutManager = LinearLayoutManager(context)
        binding.recyclerView.adapter = recyclerAdapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        viewModel.dataLaporan.observe(viewLifecycleOwner){
            recyclerAdapter.updateData(it)
        }
    }

    private fun onEditButtonClicked(p0: Laporan){
        Intent(activity, EditActivity::class.java).let {
            it.putExtra("dataLaporan", p0)
            startActivity(it)
        }
    }
    private fun onDeleteButtonClicked(p0: Laporan){
        Log.d("DeleteButton", p0.statusLaporan)
    }
    private fun onDetailClicked(p0: Laporan){
        Intent(activity, DetailActivity::class.java).let {
            it.putExtra("dataLaporan", p0)
            startActivity(it)
        }
    }
}