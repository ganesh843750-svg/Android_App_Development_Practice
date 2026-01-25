package com.example.implementation_of_recycler_view.Adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.implementation_of_recycler_view.Activity2
import com.example.implementation_of_recycler_view.Model.Ex_item
import com.example.implementation_of_recycler_view.R
import com.example.implementation_of_recycler_view.Utils.Contants

class Ex_Adapter(val context : Context, val element: MutableList<Ex_item>): RecyclerView.Adapter<Ex_Adapter.Ex_ViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): Ex_ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item,parent,false)
        return Ex_ViewHolder(view)

    }

    override fun onBindViewHolder(
        holder: Ex_ViewHolder,
        position: Int
    ) {
        val currentItem = element[position]
        holder.title.text = currentItem.title
        holder.discription.text = currentItem.discription
    }

    override fun getItemCount(): Int {
       return element.size
    }

    inner class Ex_ViewHolder(view : View): RecyclerView.ViewHolder(view){
        val title : TextView= view.findViewById(R.id.title)
        val discription : TextView = view.findViewById(R.id.discription)


        init {
            view.setOnClickListener {
                val position = bindingAdapterPosition
                val items = element[position]
                val intent = Intent( context, Activity2::class.java)
                intent.putExtra(Contants.KEY_TITLE,items.title)
                intent.putExtra(Contants.KEY_DISCRIPTION,items.discription)
                context.startActivity(intent)
                }

            }
        }


    }