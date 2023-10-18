package com.example.traveltaipei.ui.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.databinding.ItemDetailPhotoBinding
import com.example.traveltaipei.network.model.ImagesItem

class DetailPhotoAdapter : ListAdapter<ImagesItem, DetailPhotoAdapter.ViewHolder>(DiffCallBack) {

    inner class ViewHolder(private val binding: ItemDetailPhotoBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ImagesItem, position: Int) {
            binding.data = item
            binding.position = position
        }
    }

    object DiffCallBack : DiffUtil.ItemCallback<ImagesItem>() {
        override fun areItemsTheSame(oldItem: ImagesItem, newItem: ImagesItem): Boolean {
            return oldItem.src == newItem.src
        }

        override fun areContentsTheSame(oldItem: ImagesItem, newItem: ImagesItem): Boolean {
            return oldItem.src == newItem.src
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemDetailPhotoBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        ))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), position)
    }
}