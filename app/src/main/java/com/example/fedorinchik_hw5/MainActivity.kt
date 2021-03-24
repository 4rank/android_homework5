package com.example.fedorinchik_hw5

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var followClick=1

    @SuppressLint("ResourceAsColor", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)
        val subs = findViewById<TextView>(R.id.sub_number)
        val menuTop: ImageView = findViewById(R.id.menu_top)
        menuTop.setOnClickListener {
            toastView("Верхнее меню")
        }
        val menuMiddle: ImageView = findViewById(R.id.menu_middle)
        menuMiddle.setOnClickListener {
            toastView("Среднее меню")
        }
        val menuBottom: ImageView = findViewById(R.id.menu_bottom)
        menuBottom.setOnClickListener {
            toastView("Нижнее меню")
        }
        val follow: Button = findViewById(R.id.button_follow)
        follow.setOnClickListener {
            if (followClick==1) {
                follow.setBackgroundResource(R.color.green)
                follow.text = "√ Follow"
                subs.text = (7.991).toString()
                followClick=0
            }
            else {
                follow.setBackgroundResource(R.drawable.button_follow)
                follow.text = "Follow"
                subs.text= "7.990"
                followClick=1
            }
        }
        val url: TextView = findViewById(R.id.text_url)
        url.setOnClickListener {
            val browserIntent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://en.wikipedia.org/wiki/The_Simpsons")
            )
            startActivity(browserIntent)
        }
    }

    private fun toastView(text: String) {
        Toast.makeText(
            this, text,
            Toast.LENGTH_SHORT
        ).show()
    }
}