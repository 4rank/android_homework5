package com.example.fedorinchik_hw5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val COMMENT_VALUES = "photo_id"
const val COMMENT_NAME = "comment_name"
const val COMMENT_TEXT = "comment_text"

private const val COMMENT_PARAM1 = "param1"
private const val COMMENT_PARAM2 = "param2"

class CommentFragment : Fragment() {

    private val comments = listOf(
        DataComment(R.drawable.comment1, "Мэгги", "....."),
        DataComment(R.drawable.comment2, "Фландерс", "Отличное фото сосед!"),
        DataComment(R.drawable.comment3, "Милхаус", "Барт должен гордиться своим отцом"),
        DataComment(R.drawable.comment4, "Барт", "Ничего я не должен, ты офигел, Милхаус?")
    )

    private lateinit var recycler: RecyclerView
    private var photoFrag1: String? = null
    private var photoFrag2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photoFrag1 = it.getString(COMMENT_PARAM1)
            photoFrag2 = it.getString(COMMENT_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val startFragment = inflater.inflate(R.layout.comment_gallery, container, false)
        recyclerStart(startFragment)
        return startFragment
    }

    private fun recyclerStart(view: View) {
        recycler = view.findViewById(R.id.RecyclerView_comment)
        val adapter = AdapterComment(comments) {
            val intent = Intent(this.context, CommentPhotoActivity::class.java)
            intent.putExtra(COMMENT_VALUES, it.commentValues)
            intent.putExtra(COMMENT_NAME, it.commentName)
            intent.putExtra(COMMENT_TEXT, it.commentText)
            startActivity(intent)
        }
        recycler.adapter = adapter
        recycler.layoutManager =
            LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
    }
}