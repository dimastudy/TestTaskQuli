package com.example.testtaskqulisoft.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.testtaskqulisoft.R
import com.example.testtaskqulisoft.databinding.ItemPhotoBinding
import com.example.testtaskqulisoft.domain.PhotoDomain

class PhotosAdapter(
    private val photoClick: PhotoClick
) : PagingDataAdapter<PhotoDomain, PhotosAdapter.PhotosViewHolder>(DiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = ItemPhotoBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.item_photo, parent, false)
        )
        return PhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        val photo = getItem(position)
        holder.bind(photo!!)
        holder.itemView.setOnClickListener {
            photoClick.click(photo)
        }
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<PhotoDomain>() {
            override fun areItemsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: PhotoDomain, newItem: PhotoDomain): Boolean =
                oldItem == newItem

        }
    }

    class PhotosViewHolder(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(photo: PhotoDomain) {
            binding.apply {
                Glide.with(itemView.context).load(photo.photoSmallLink).into(photoSmall)
                textUsername.text = photo.photoCreatorUsername
                textDescription.text = photo.photoDescription
            }
        }

    }


}

interface PhotoClick {
    fun click(photo: PhotoDomain)
}