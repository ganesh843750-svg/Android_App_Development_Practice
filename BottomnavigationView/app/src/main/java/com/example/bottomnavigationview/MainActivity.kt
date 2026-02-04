package com.example.bottomnavigationview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.Fragments.fragment_fav
import com.example.bottomnavigationview.Fragments.fragment_home
import com.example.bottomnavigationview.Fragments.fragment_search
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var bottomNavigation : BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        bottomNavigation = findViewById(R.id.nav_view)
        bottomNavigation.setOnItemSelectedListener {
            var fragment: Fragment? = when (it.itemId) {
                R.id.nav_home -> { fragment_home()
                }

                R.id.nav_fav -> {
                    fragment_fav()
                }

                R.id.nav_search -> {
                    fragment_search()
                }

                else -> { null
                }

            }
            if(fragment != null){
                supportFragmentManager.beginTransaction().replace(R.id.nav_view, fragment).commit()
                return@setOnItemSelectedListener true
            }
            else{
                return@setOnItemSelectedListener false
            }
        }


    }
}