package com.example.textwatcher

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var et_name : EditText
    private lateinit var et_pass : EditText
    private lateinit var  btn_login : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        et_name = findViewById(R.id.et_name)
        et_pass = findViewById(R.id.et_pass)
        btn_login = findViewById(R.id.btn_login)
        et_name.addTextChangedListener(textwatcher)
        et_pass.addTextChangedListener(textwatcher)


    }
    private val textwatcher = object : TextWatcher{
        override fun afterTextChanged(s: Editable?) {


        }

        override fun beforeTextChanged(
            s: CharSequence?,
            start: Int,
            count: Int,
            after: Int
        ) {

        }

        override fun onTextChanged(
            s: CharSequence?,
            start: Int,
            before: Int,
            count: Int
        ) {
            btn_login.isEnabled = !et_name.text.toString().trim().isEmpty()
                    && !et_pass.text.toString().trim().isEmpty()
        }

    }
}