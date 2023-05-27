package com.skeleton.myapplication.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import by.kirich1409.viewbindingdelegate.viewBinding
import com.skeleton.myapplication.R
import com.skeleton.myapplication.databinding.FragmentDetailBinding
import com.skeleton.myapplication.databinding.FragmentHomeBinding
import com.skeleton.myapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding: FragmentDetailBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }

    private fun fetchData() {
        viewModel.getDetail("clFqa_bYcqY").observe(viewLifecycleOwner) {
            Log.d("CEK RESPONSE SUSSUS", it.toString())
        }
    }
}