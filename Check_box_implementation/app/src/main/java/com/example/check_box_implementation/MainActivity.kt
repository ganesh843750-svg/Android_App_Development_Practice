package com.example.check_box_implementation

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var  check_java : CheckBox
    lateinit var  check_kotlin : CheckBox
    lateinit var  check_py : CheckBox
    lateinit var btn : Button
    lateinit var tv : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        check_java =  findViewById(R.id.check_java)
        check_kotlin =  findViewById(R.id.check_kotlin)
        check_py =  findViewById(R.id.check_py)
        btn =  findViewById(R.id.btn)
        tv = findViewById(R.id.tv)
        btn.setOnClickListener {
            val sb = StringBuilder()
            sb.append("Selected languages are : \n")
            if (check_java.isChecked){
                sb.append(check_java.text.toString() + "\n")
            }
            if (check_kotlin.isChecked){
                sb.append(check_kotlin.text.toString() + "\n")
            }
            if (check_py.isChecked){
                sb.append(check_py.text.toString() + "\n")
            }
            tv.text = sb.toString()
            tv.visibility = View.VISIBLE
        }
    }
}