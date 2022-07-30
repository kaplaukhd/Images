package com.kaplaukhd.images.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.kaplaukhd.images.R
import com.kaplaukhd.images.api.ImagesApi

class ImageAdapter(private val context: Context, private val dataset: ArrayList<ImagesApi>) :
    RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.image_item, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = dataset[position]
        Glide.with(context).load(item.urls.small).into(holder.image)
    }

    override fun getItemCount() = dataset.size


    class ImageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById<ImageView>(R.id.image_holder)
    }
}



