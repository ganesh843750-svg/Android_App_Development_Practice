package com.example.toolbar

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.ex_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.item1 -> {
                Toast.makeText(this, "Item 1 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item2 -> {
                Toast.makeText(this, "Item 2 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.item3 -> {
                Toast.makeText(this, "Item 3 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.sub_item1 -> {
                Toast.makeText(this, "Sub Item 1 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.sub_item2 -> {
                Toast.makeText(this, "Sub Item 2 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

            R.id.sub_item3 -> {
                Toast.makeText(this, "Sub Item 3 Clicked", Toast.LENGTH_SHORT).show()
                return true
            }

        }
        return super.onOptionsItemSelected(item)
    }
}