package com.skeleton.myapplication.ui.home

import android.os.Bundle
import android.util.LayoutDirection
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.skeleton.myapplication.R
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.databinding.FragmentHomeBinding
import com.skeleton.myapplication.ui.adapter.PhotosAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(R.layout.fragment_home) {
    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel : HomeViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fetchData()
    }
    private fun fetchData(){
        viewModel.getPhotos().observe(viewLifecycleOwner){
            when(it){
                is EventResult.Error ->{
                }
                is EventResult.Loading->{
                }
                is EventResult.Success->{
                    val adapter = PhotosAdapter(it.data)
                    val layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
                    binding.storyRecyclerView.setHasFixedSize(true)
                    binding.storyRecyclerView.layoutManager = layoutManager
                    binding.storyRecyclerView.adapter = adapter
                }
            }
        }
    }
}