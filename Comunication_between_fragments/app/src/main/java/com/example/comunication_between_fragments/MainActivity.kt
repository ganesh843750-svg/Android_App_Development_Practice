package com.example.comunication_between_fragments

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.comunication_between_fragments.Fragments.fragment_a
import com.example.comunication_between_fragments.Fragments.fragment_b

class MainActivity : AppCompatActivity(),
    fragment_a.FragmentAListener ,
    fragment_b.FragmentBListener{
    private lateinit var fragmentA: fragment_a
    private lateinit var fragmentB: fragment_b

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        fragmentA = fragment_a()
        fragmentB = fragment_b()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_a, fragmentA)
            .commit()

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_b, fragmentB)
            .commit()


    }

    override fun sendFromA(input: String) {
        fragmentB.UpadteTEXT(input)

    }

    override fun sendFromB(input: String) {
        fragmentA.UpadteTEXT(input)
    }
}