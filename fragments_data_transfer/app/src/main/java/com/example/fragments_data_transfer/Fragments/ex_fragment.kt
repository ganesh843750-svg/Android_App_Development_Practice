package com.example.fragments_data_transfer.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragments_data_transfer.R

// User difined Fragment class that inherits from class Fragment
class ex_fragment: Fragment(){
    // varibles for accepting the data passed through bundle
    private var name = ""
    private var age = -1
//This is the function that overide and infale the fragment and return to the avctivity
    override fun onCreateView(

        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment or connecting fragment layout to the fragment
        val viwe = inflater.inflate(R.layout.ex_fragments,container,false)
    // after inflating the layout or  connecting fragment layout to the fragment, connecting  text viwe to the variable using
    // findviweby id function
        val tv : TextView = viwe.findViewById(R.id.tv)
// retrieving the data passed through bundle
        arguments?.let {
            name = it.getString("name","No Name")
            age = it.getInt("age",0)
        }
    // setting the data to the text viwe
        tv.text = name + "\n" + age.toString()
    //returning the inflated fragment view
        return viwe

    }

}