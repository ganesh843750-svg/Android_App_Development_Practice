package com.example.theames_implementation

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class second_activity : AppCompatActivity() {
    lateinit var mains: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_second)
        mains = findViewById(R.id.main)
        mains.setOnClickListener {
            Intent(this, MainActivity::class.java).also {
                startActivity(it)
            }


        }
    }
}