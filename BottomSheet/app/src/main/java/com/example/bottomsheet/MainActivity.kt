package com.example.bottomsheet

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bottomsheet.Dialogues.MyBottomSheetDialogue

class MainActivity : AppCompatActivity(), MyBottomSheetDialogue.BottomSheetListener {
    private lateinit var openDialogButton : Button
    private lateinit var textViweButton : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        openDialogButton = findViewById(R.id.btn_open_dialog)
        textViweButton = findViewById(R.id.textviwe)

        openDialogButton.setOnClickListener {
            val myBottomSheetDialogue = MyBottomSheetDialogue()
            myBottomSheetDialogue.show(supportFragmentManager,"Dialog")
        }


    }

    override fun onButtonClicked(text: String) {
        textViweButton.text = text
    }

}