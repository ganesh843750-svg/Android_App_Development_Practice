package com.example.navigating_from_one_activity_to_another

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    lateinit var tv : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        tv  = findViewById(R.id.data)
        val data = intent.extras
        data?.let {
            val message = data.getString(Cons.INTENT_MESSAGE_KEY)
            val message2 = data.getString(Cons.INTENT_MESSAGE_KEY2)
            val message3 = data.getString(Cons.INTENT_MESSAGE3_KEY)
            tv.text = message + "\n"+message2 + "\n" + message3
        }
    }
}