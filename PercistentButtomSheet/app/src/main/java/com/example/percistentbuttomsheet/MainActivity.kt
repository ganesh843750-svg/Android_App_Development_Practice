package com.example.percistentbuttomsheet

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomsheet.BottomSheetBehavior
import java.time.ZoneOffset

class MainActivity : AppCompatActivity() {
    private lateinit var  bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var  textviewSates : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val view : View = findViewById(R.id.bottom_sheet)
        bottomSheetBehavior = BottomSheetBehavior.from(view)
        val btnOpen : Button = findViewById(R.id.btn_open)
        val btnClose : Button = findViewById(R.id.btn_colapse)
        textviewSates = findViewById(R.id.tv)

        btnOpen.setOnClickListener {
           bottomSheetBehavior.state = BottomSheetBehavior.STATE_EXPANDED
            textviewSates.text = "EXPANDED"
        }
        btnClose.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            textviewSates.text = "COLLAPSED"

        }
        bottomSheetBehavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback(){
            override fun onStateChanged(bottomSheet: View, newState: Int) {
                when(newState){
                    BottomSheetBehavior.STATE_EXPANDED ->{
                        textviewSates.text = "EXPANDED"
                    }
                    BottomSheetBehavior.STATE_DRAGGING ->{
                        textviewSates.text = "DRAGGING"
                    }
                    BottomSheetBehavior.STATE_SETTLING ->{
                        textviewSates.text = "SETTLING"
                    }
                    BottomSheetBehavior.STATE_COLLAPSED -> {
                        textviewSates.text = "COLLAPSED"
                    }
                }

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {

            }

        })
    }
}