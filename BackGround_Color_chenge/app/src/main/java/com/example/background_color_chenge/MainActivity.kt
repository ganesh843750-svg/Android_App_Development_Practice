package com.example.background_color_chenge

import android.graphics.Color
import android.os.Bundle
import android.provider.CalendarContract
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    lateinit var btn_d : Button
    lateinit var btn_R : Button
    lateinit var layout : ConstraintLayout
    lateinit var Random_Bg : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
       btn_d = findViewById(R.id.btn_d)
        btn_R = findViewById(R.id.btn_R)
       layout = findViewById(R.id.main)
        Random_Bg = findViewById(R.id.rand_bg_btn)
        var colors  = arrayOf(Color.BLACK, Color.BLUE, Color.CYAN, Color.DKGRAY, Color.GRAY, Color.GREEN,
            Color.LTGRAY, Color.MAGENTA,Color.RED, Color.YELLOW, Color.WHITE)


        btn_R.setOnClickListener {
            layout.setBackgroundColor(getColor(R.color.yellow))
            btn_R.text = "Read Mode On"
            btn_d.text = "Dark Mode"
        }
        btn_d.setOnClickListener {
            layout.setBackgroundColor(getColor(R.color.black))
            btn_d.text = "Dark Mode on"
            btn_R.text = "Reade Mode"
        }
        Random_Bg.setOnClickListener {
            layout.setBackgroundColor(colors.random())
        }


    }
}