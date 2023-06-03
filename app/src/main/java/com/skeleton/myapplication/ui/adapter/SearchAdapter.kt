package com.skeleton.myapplication.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.skeleton.myapplication.Utils
import com.skeleton.myapplication.data.network.response.home.HomeResponseItem
import com.skeleton.myapplication.data.network.response.search.ResultsItem
import com.skeleton.myapplication.databinding.ItemListBinding
import com.skeleton.myapplication.databinding.ItemSearchBinding
import com.skeleton.myapplication.ui.home.HomeFragmentDirections
import com.skeleton.myapplication.ui.home.ShareFragmentDirections

class SearchAdapter(
    private val listUser: List<ResultsItem>
) : RecyclerView.Adapter<SearchAdapter.ViewHolder>(){
    class ViewHolder(val binding : ItemSearchBinding) : RecyclerView.ViewHolder(binding.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemSearchBinding.inflate(LayoutInflater.from(parent.context),parent,false)
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
            it.findNavController().navigate(ShareFragmentDirections.actionShareFragmentToDetailFragment(listUser[position].id))
        }
    }
    override fun getItemCount(): Int {
        return listUser.size
    }
}