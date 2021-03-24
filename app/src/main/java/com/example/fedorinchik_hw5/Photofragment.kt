package com.example.fedorinchik_hw5

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

const val PHOTO_VALUES = "photo_id"

private const val PHOTO_PARAM1 = "param1"
private const val PHOTO_PARAM2 = "param2"

class PhotoFragment : Fragment() {

    private val photos = listOf(
        DataPhoto(R.drawable.photo1),
        DataPhoto(R.drawable.photo2),
        DataPhoto(R.drawable.photo3),
        DataPhoto(R.drawable.photo4),
        DataPhoto(R.drawable.photo5),
        DataPhoto(R.drawable.photo6),
        DataPhoto(R.drawable.photo7),
    )

    private lateinit var recycler: RecyclerView
    private var photoFrag1: String? = null
    private var photoFrag2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            photoFrag1 = it.getString(PHOTO_PARAM1)
            photoFrag2 = it.getString(PHOTO_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val startFragment = inflater.inflate(R.layout.photo_gallery, container, false)
        recyclerStart(startFragment)
        return startFragment
    }

    private fun recyclerStart(view: View) {
        recycler = view.findViewById(R.id.RecyclerView_photo)
        val adapter = AdapterPhotos(photos) {
            val intent = Intent(this.context, CommentPhotoActivity::class.java)
            intent.putExtra(PHOTO_VALUES, it.photoValues)
            startActivity(intent)
        }
        recycler.adapter = adapter
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(
            this.context,
            2,
            GridLayoutManager.VERTICAL,
            false
        )
    }
}