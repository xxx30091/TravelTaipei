package com.example.traveltaipei.ui.attractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.network.model.AttractionItem
import com.example.traveltaipei.databinding.ItemAttractionBinding

class AttractionsAdapter(private val viewModel: AttractionsViewModel) : ListAdapter<AttractionItem, AttractionsAdapter.AttractionsViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<AttractionItem>() {
        override fun areItemsTheSame(oldItem: AttractionItem, newItem: AttractionItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AttractionItem, newItem: AttractionItem): Boolean {
            return oldItem.id == newItem.id
        }
    }

    class AttractionsViewHolder(private val binding: ItemAttractionBinding) :RecyclerView.ViewHolder(binding.root) {
        fun bind(item: AttractionItem, viewModel: AttractionsViewModel) {
            binding.item = item
            binding.model = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttractionsViewHolder {
        return AttractionsViewHolder(ItemAttractionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: AttractionsViewHolder, position: Int) {
        holder.bind(getItem(position), viewModel)
    }

}