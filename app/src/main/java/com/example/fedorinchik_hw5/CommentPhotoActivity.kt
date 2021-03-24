package com.example.fedorinchik_hw5

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CommentPhotoActivity : AppCompatActivity() {

    private var viewPhoto: Int? = null
    private var like=1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val photoView = findViewById<View>(R.id.comment_photo)
        val likes = findViewById<TextView>(R.id.likes)
        val comments = findViewById<TextView>(R.id.comments)
        comments.text = "4"
        val randomLikes = (3259 until 7261).random()
        likes.text = randomLikes.toString()
        val bundle = intent.extras
        viewPhoto = bundle?.getInt(PHOTO_VALUES)
        viewPhoto?.let {
            photoView.setBackgroundResource(it)
        }
        val setLike = findViewById<ImageView>(R.id.set_like)
        setLike.setOnClickListener {
            if (like==1) {
                setLike.setImageResource(R.drawable.heart)
                likes.text = (randomLikes + 1).toString()
                like=0
            }
            else{
                setLike.setImageResource(R.drawable.notlike_heart)
                likes.text = randomLikes.toString()
                like=1
            }
        }
    }
}
