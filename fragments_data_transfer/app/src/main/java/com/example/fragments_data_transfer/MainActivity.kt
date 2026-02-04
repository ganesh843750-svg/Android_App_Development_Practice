package com.example.fragments_data_transfer

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.fragments_data_transfer.Fragments.ex_fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Creating of object of fragment class
        val fragment = ex_fragment()
        // Criatig object of inbuilt class Bundle
        // Passing data to fragment using bundele, we can also pass data using Constructor but it will
        // will not work or cause crash of app on changing the orientation or rotating the phone
        val bundle = Bundle()
        // Passing data to fragment using bundele, we can also pass data using Constructor but it will
        // will not work or cause crash of app on changing the orientation or rotating the phone
        bundle.putString("name","Ganesh")
        bundle.putInt("age",21)

        // Passing data to fragment using bundele
        fragment.arguments = bundle

        // Replacing the fragment in activity
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
            .commit()

    }
}