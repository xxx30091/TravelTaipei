package com.example.traveltaipei.utils

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.example.traveltaipei.network.model.AttractionItem
import com.example.traveltaipei.ui.attractions.AttractionsAdapter

@BindingAdapter("imgUrl")
fun bindImg(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        Glide.with(imgView.context)
            .load(imgUrl)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imgView)
    }
}

@BindingAdapter("item")
fun bindRecyclerViewWithItems(recyclerView: RecyclerView, item: List<AttractionItem>?) {
    item?.let {
        recyclerView.adapter?.apply {
            when (this) {
                is AttractionsAdapter -> submitList(it)
            }
        }
    }
}