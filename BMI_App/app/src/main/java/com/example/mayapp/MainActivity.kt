package com.example.mayapp

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var et_weight : EditText
    lateinit var et_height : EditText
    lateinit var btn_calculate : Button
    lateinit var tv_result : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       et_weight = findViewById(R.id.weight)
        et_height = findViewById(R.id.height)
        tv_result = findViewById(R.id.result)
        btn_calculate = findViewById(R.id.calculate)

        btn_calculate.setOnClickListener {
            if(!et_height.text.isNullOrEmpty() && !et_weight.text.isNullOrEmpty()) {
                val weight = et_weight.text.toString().toDouble()
                val height = et_height.text.toString().toDouble()
                val  result = weight/ (height*height)
                tv_result.textSize = 30f
                tv_result.visibility = View.VISIBLE
                if (result < 18.5) {
                    tv_result.text = "Your BMI is $result. \n\n You are underweight"
                    tv_result.setTextColor(getColor(R.color.red))

                } else if (result >= 18.5 && result <= 24.9) {
                    tv_result.text = "Your BMI is $result. \n\n Congragulations, You are Healthy"
                    tv_result.setTextColor(getColor(R.color.green))

                } else if (result >= 2 && result <= 29.9) {
                    tv_result.text = "Your BMI is $result. \n\n You are In the range of Overweight"
                    tv_result.setTextColor(getColor(R.color.orange))

                } else if (result >= 30 && result <= 34.9) {
                    tv_result.text =
                        "Your BMI is $result. \n\n You are In the range of Obese Class I"
                    tv_result.setTextColor(getColor(R.color.red))

                } else if (result >= 35 && result <= 39.9) {
                    tv_result.text =
                        "Your BMI is $result. \n\n You are In the range of Obese Class II"
                    tv_result.setTextColor(getColor(R.color.red))

                } else {
                    tv_result.text =
                        "Your BMI is $result. \n\n You are In the range of Obese Class III and Its Severely Obese"
                    tv_result.setTextColor(getColor(R.color.red))

                }

                }
            else{
                tv_result.text = "Please Enter your Details: \n Height and Weight"
                tv_result.setTextColor(getColor(R.color.black))
                tv_result.textSize = 20f
                tv_result.visibility = View.VISIBLE
            }

        }


    }
}