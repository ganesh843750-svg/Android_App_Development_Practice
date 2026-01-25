package com.example.quizeapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.quizeapp.ui.Qustions_Activity
import com.example.quizeapp.utils.Constants

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val btn_start : Button = findViewById(R.id.btn_start)
        val etTextName : EditText = findViewById(R.id.name)

        btn_start.setOnClickListener {
            if(!etTextName.text.isEmpty()){
                Intent(this@MainActivity, Qustions_Activity ::class.java).also {
                    it.putExtra(Constants.USER_NAME,etTextName.text.toString())
                    startActivity(it)
                    finish()
                }
            }
            else {
                Toast.makeText(this@MainActivity,"Please enter your name ", Toast.LENGTH_SHORT).show()
            }
        }


    }
}