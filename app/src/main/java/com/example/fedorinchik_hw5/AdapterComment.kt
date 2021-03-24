package com.example.fedorinchik_hw5

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdapterComment(
    private val comments: List<DataComment>, private val onClick: (DataComment) -> Unit
) :
    RecyclerView.Adapter<AdapterComment.ViewHolderCurrentColor>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderCurrentColor {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.comment_layout, parent, false)
        return ViewHolderCurrentColor(view, onClick)
    }

    override fun getItemCount(): Int {
        return comments.size
    }

    override fun onBindViewHolder(holder: ViewHolderCurrentColor, pos: Int) {
        holder.bindViewHolder(comments[pos])
    }

    class ViewHolderCurrentColor(view: View, val onClick: (DataComment) -> Unit) :
        RecyclerView.ViewHolder(view) {
        private var currentViewHolderComment: DataComment? = null
        private val viewHolderComment = view.findViewById<View>(R.id.comment_image)
        private val nameComment = view.findViewById<TextView>(R.id.comment_name)
        private val textComment = view.findViewById<TextView>(R.id.comment_text)

        init {
            view.setOnClickListener {
                currentViewHolderComment?.let {
                    onClick(it)
                }
            }
        }

        fun bindViewHolder(currentComment: DataComment) {
            currentViewHolderComment = currentComment
            viewHolderComment.setBackgroundResource(currentComment.commentValues)
            nameComment.text = currentComment.commentName
            textComment.text = currentComment.commentText
        }
    }
}