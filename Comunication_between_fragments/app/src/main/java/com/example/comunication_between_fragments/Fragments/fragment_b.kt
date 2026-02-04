package com.example.comunication_between_fragments.Fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.comunication_between_fragments.Fragments.fragment_a.FragmentAListener
import  com.example.comunication_between_fragments.R
import org.w3c.dom.Text


class fragment_b() : Fragment(){
    private lateinit var eta_b : EditText
    private lateinit var btn_b : Button
    private lateinit var listener: FragmentBListener


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        eta_b = view.findViewById(R.id.eta_b)
        btn_b = view.findViewById(R.id.btn_b)

        btn_b.setOnClickListener {
            listener.sendFromB(eta_b.text.toString())

        }


      return view
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is FragmentBListener){
            listener = context
        }
        else{
            throw RuntimeException(context.toString() + " You must implement FragmentBListener")
        }
    }
    fun UpadteTEXT(input : String){
        eta_b.setText(input)
    }

    interface FragmentBListener{
        fun sendFromB(input : String)
    }
}