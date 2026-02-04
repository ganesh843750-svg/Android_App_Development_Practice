package com.example.comunication_between_fragments.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import  com.example.comunication_between_fragments.R
import org.w3c.dom.Text


class fragment_a() : Fragment(){
    private lateinit var eta_a : EditText
    private lateinit var btn_a : Button
    private lateinit var listener: FragmentAListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)
        eta_a = view.findViewById(R.id.eta_a)
        btn_a = view.findViewById(R.id.btn_a)

        btn_a.setOnClickListener {
            listener.sendFromA(eta_a.text.toString())

        }


      return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentAListener){
            listener = context
        }
        else{
            throw RuntimeException(context.toString() + " You must implement FragmentAListener")
        }
    }
    fun UpadteTEXT(input : String){
        eta_a.setText(input)
    }

    interface FragmentAListener{
        fun sendFromA(input : String)
    }
}