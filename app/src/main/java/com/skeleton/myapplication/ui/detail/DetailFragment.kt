package com.skeleton.myapplication.ui.detail

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.skeleton.myapplication.R
import com.skeleton.myapplication.Utils
import com.skeleton.myapplication.data.EventResult
import com.skeleton.myapplication.databinding.FragmentDetailBinding
import com.skeleton.myapplication.ui.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding: FragmentDetailBinding by viewBinding()
    private val viewModel: MainViewModel by viewModel()
    private val argument : DetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fetchData()
    }
    private fun fetchData() {
        viewModel.getDetail(argument.id).observe(viewLifecycleOwner) {
            when(it){
                is EventResult.Error ->{
                }
                is EventResult.Loading->{
                }
                is EventResult.Success->{
                    Glide.with(requireContext())
                        .load(it.data.urls.small)
                        .into(binding.photoImageView)

                    Glide.with(requireContext())
                        .load(it.data.user.profileImage.small)
                        .into(binding.avatarImageView)
                    binding.createdTextView.text = it.data.promotedAt
                    binding.usernameTextView.text = it.data.user.username
                    binding.descriptionTextView.text = Utils.capitalizeFirstLetter(it.data.altDescription)
                }
            }
        }
    }

}