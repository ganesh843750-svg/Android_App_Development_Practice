package com.example.navigating_from_one_activity_to_another

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
            val intent = Intent(this, Activity2::class.java)
//            Intent(this@MainActivity, Activity2::class.java).also {
//                startActivity(it)
//            }
            intent.putExtra(Cons.INTENT_MESSAGE_KEY," Hello from Gani")
            intent.putExtra(Cons.INTENT_MESSAGE_KEY2," How are you?")
            intent.putExtra(Cons.INTENT_MESSAGE3_KEY," How was your day toady ?")
            startActivity(intent)
        }
    }
}