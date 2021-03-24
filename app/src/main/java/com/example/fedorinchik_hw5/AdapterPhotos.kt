package com.example.fedorinchik_hw5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterPhotos(
    private val photos: List<DataPhoto>, private val onClick: (DataPhoto) -> Unit
) :
    RecyclerView.Adapter<AdapterPhotos.ViewHolderCurrentColor>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCurrentColor {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.photo_layout, parent, false)
        return ViewHolderCurrentColor(view, onClick)
    }

    override fun getItemCount(): Int {
        return photos.size
    }

    override fun onBindViewHolder(holder: ViewHolderCurrentColor, pos: Int) {
        holder.bindViewHolder(photos[pos])
    }

    class ViewHolderCurrentColor(view: View, val onClick: (DataPhoto) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private var currentViewHolderPhoto: DataPhoto? = null
        private val viewHolderColor = view.findViewById<View>(R.id.photo_view)

        init {
            view.setOnClickListener {
                currentViewHolderPhoto?.let {
                    onClick(it)
                }
            }
        }

        fun bindViewHolder(currentPhoto: DataPhoto) {
            currentViewHolderPhoto = currentPhoto
            viewHolderColor.setBackgroundResource(currentPhoto.photoValues)
        }
    }
}