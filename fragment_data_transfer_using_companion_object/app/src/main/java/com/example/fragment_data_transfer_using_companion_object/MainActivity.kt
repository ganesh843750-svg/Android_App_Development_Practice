package com.example.fragment_data_transfer_using_companion_object

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fragment_data_transfer_using_companion_object.Fragments.ex_fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val fragment = ex_fragment.newInstance("hello",123)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container, fragment)
            .commit()


    }
}