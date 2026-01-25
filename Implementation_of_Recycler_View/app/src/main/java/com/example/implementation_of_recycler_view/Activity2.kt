package com.example.implementation_of_recycler_view

import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.annotation.Dimension
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.implementation_of_recycler_view.Utils.Contants

class Activity2 : AppCompatActivity() {
    lateinit var titlet_tv : TextView
    lateinit var discription_tv : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        titlet_tv = findViewById(R.id.title)
        discription_tv = findViewById(R.id.discription)
      val data = intent.extras
        data?.let{
            titlet_tv.text = it.getString(Contants.KEY_TITLE)
            discription_tv.text = it.getString(Contants.KEY_DISCRIPTION)
        }
    }
}