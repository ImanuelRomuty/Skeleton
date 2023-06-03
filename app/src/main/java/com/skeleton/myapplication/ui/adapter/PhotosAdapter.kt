package com.skeleton.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skeleton.myapplication.Utils
import com.skeleton.myapplication.data.network.response.home.HomeResponseItem
import com.skeleton.myapplication.databinding.ItemListBinding
import com.skeleton.myapplication.ui.home.HomeFragmentDirections

class PhotosAdapter(
    private val listUser: List<HomeResponseItem>
) : RecyclerView.Adapter<PhotosAdapter.ViewHolder>(){
    class ViewHolder(val binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder.binding){
            Glide.with(holder.itemView.context)
                .load(listUser[position].urls.regular)
                .into(holder.binding.photoImageView)
            val desc = Utils.capitalizeFirstLetter(listUser[position].altDescription)
            holder.binding.descTextView.text = desc
        }
        holder.itemView.setOnClickListener {
            it.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(listUser[position].id))
        }
    }
    override fun getItemCount(): Int {
        return listUser.size
    }
}