package com.example.rdio_btn_implementation

import android.os.Bundle
import android.widget.GridLayout
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var layout: LinearLayout
    lateinit var radiogrpup : RadioGroup
    lateinit var radioButton : RadioButton

    lateinit var rateapp : SeekBar
    lateinit var rateshow : TextView
    lateinit var tglbtn : ToggleButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        radiogrpup = findViewById(R.id.radioGroup)


        radiogrpup.setOnCheckedChangeListener { radiogrpup, id ->
            radioButton = findViewById(id)
            when(radioButton.id){
                R.id.java -> {
                    Toast.makeText(this@MainActivity, "Java selected", Toast.LENGTH_SHORT).show()
                }
                R.id.sql -> {
                    Toast.makeText(this@MainActivity, "SQL selected", Toast.LENGTH_SHORT).show()
                }
                R.id.kotlin -> {
                    Toast.makeText(this@MainActivity, "Kotlin selected", Toast.LENGTH_SHORT).show()
                }
                R.id.html -> {
                    Toast.makeText(this@MainActivity, "HTML selected", Toast.LENGTH_SHORT).show()
                }
                R.id.python -> {
                    Toast.makeText(this@MainActivity, "Python selected", Toast.LENGTH_SHORT).show()
                }
            }
        }


        rateapp = findViewById(R.id.seekBar)
        rateshow = findViewById(R.id.rateshow)

        rateapp.setOnSeekBarChangeListener( object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                Toast.makeText(this@MainActivity, "on Progrss chenged", Toast.LENGTH_SHORT).show()
                rateshow.text = "Rate is : $progress"
            }
            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MainActivity,"On Start Tracking", Toast.LENGTH_SHORT).show()
                }
            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                Toast.makeText(this@MainActivity,"On Stop Tracking", Toast.LENGTH_SHORT).show()
                rateshow.text = " Final Rate is : ${seekBar!!.progress}"
            }
        })


        tglbtn = findViewById(R.id.toglebtn)
        layout = findViewById(R.id.main)

        tglbtn.setOnCheckedChangeListener { buttonView, isChecked ->
            if ( isChecked){
                layout.setBackgroundColor(getColor(R.color.black))
            }
            else{
                layout.setBackgroundColor(getColor(R.color.white))
            }
 }
    }
}