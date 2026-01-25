package com.example.quizeapp.utils

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.quizeapp.MainActivity
import com.example.quizeapp.R

class Result_Activity : AppCompatActivity() {
    private lateinit var tv_Score : TextView
    private lateinit var tv_name : TextView
    private lateinit var btn_finish : AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)
        tv_Score = findViewById(R.id.score)
        tv_name = findViewById(R.id.user_name)
        btn_finish = findViewById(R.id.btn_finish)
        val totalQustions = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        val  username = intent.getStringExtra(Constants.USER_NAME)
        val score = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)

        tv_name.text = username
        tv_Score.text = "Your score is $score out of $totalQustions"
        btn_finish.setOnClickListener {
            Intent(this, MainActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}