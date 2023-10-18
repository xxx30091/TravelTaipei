package com.example.traveltaipei.ui.attractions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.traveltaipei.databinding.ItemLanguageBinding
import com.example.traveltaipei.network.model.Language

class LanguageAdapter(val viewModel: AttractionsViewModel) : RecyclerView.Adapter<LanguageAdapter.LanguageViewHolder>() {
    private var mList = arrayListOf<Language>()

    class LanguageViewHolder(val binding: ItemLanguageBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Language, viewModel: AttractionsViewModel) {
            binding.language = item
            binding.viewModel = viewModel
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LanguageViewHolder {
        return LanguageViewHolder(ItemLanguageBinding.inflate(LayoutInflater.from(parent.context)))
    }

    override fun getItemCount() = mList.size

    override fun onBindViewHolder(holder: LanguageViewHolder, position: Int) {
        holder.bind(mList[position], viewModel)
    }

    fun updateList(list: ArrayList<Language>) {
        mList = list
    }
}