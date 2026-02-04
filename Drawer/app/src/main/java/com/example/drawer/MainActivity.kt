package com.example.drawer

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.drawer.Fragments.Message_fragment
import com.example.drawer.Fragments.Profile_Fragment
import com.example.drawer.Fragments.chat_fragment
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private  lateinit var drawer: DrawerLayout


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val toolbar : androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawer = findViewById(R.id.drawer_layout)

        val navigationView = findViewById<NavigationView>(R.id.nave_view)


        val toggle = ActionBarDrawerToggle(this@MainActivity,drawer, toolbar
        , R.string.Nav_drawer_open,R.string.Nav_drawer_close).syncState()
        navigationView.setCheckedItem(R.id.message)
        navigationView.setNavigationItemSelectedListener{ item ->
                when(item.itemId){
                    R.id.message ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, Message_fragment())
                            .commit()
                    }
                    R.id.chat ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, chat_fragment())
                            .commit()
                    }
                    R.id.profile ->{
                        supportFragmentManager
                            .beginTransaction()
                            .replace(R.id.fragment_container, Profile_Fragment())
                            .commit()
                    }
                    R.id.send ->{
                        Toast.makeText(this@MainActivity,"Send clicked", Toast.LENGTH_SHORT).show()
                    }
                    R.id.share->{
                        Toast.makeText(this@MainActivity,"Share clicked", Toast.LENGTH_SHORT).show()
                }
            }
            drawer.closeDrawer(GravityCompat.START)
            return@setNavigationItemSelectedListener true

        }


        onBackPressedDispatcher.addCallback(this){
            if(drawer.isDrawerOpen(GravityCompat.START)){
                drawer.closeDrawer(GravityCompat.START)
            }
            else{
                finish()
            }
        }


    }
}