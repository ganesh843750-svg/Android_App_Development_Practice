package com.example.implementation_of_recycler_view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.implementation_of_recycler_view.Adapters.Ex_Adapter
import com.example.implementation_of_recycler_view.Model.Ex_item

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerview : RecyclerView
    private lateinit var adapter: Ex_Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val Ex_list = generateList(100)
        adapter = Ex_Adapter(this,Ex_list)
        recyclerview = findViewById(R.id.recycler_view)
        recyclerview.adapter = adapter
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.setHasFixedSize(true)
    }

    private fun generateList(size : Int): MutableList<Ex_item>{
        val list = mutableListOf<Ex_item>()

        for (i in 0 until size){
            list.add(Ex_item("Title $i","Description $i"))
        }
        return list
    }
}