package com.example.fragment_data_transfer_using_companion_object.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fragment_data_transfer_using_companion_object.R

private const val ARGS_TEXT = "text"
private const val ARGS_NUMBER = "number"

class ex_fragment : Fragment(){
    private var name = ""
    private var number = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.ex_fragment,container,false)
        val tv : TextView = view.findViewById(R.id.tv)

        arguments?.let {
            name = it.getString(ARGS_TEXT,"No text")
            number = it.getInt(ARGS_NUMBER, -1)
        }
        tv.text = name + "\n" + number

        return view
    }
    companion object{
//        fun newInstance(text : String, number: Int): ex_fragment{
//            val fragment = ex_fragment()
//            val bundle = Bundle()
//            bundle.putString(ARGS_TEXT,text)
//            bundle.putInt(ARGS_NUMBER,number)
//            fragment.arguments = bundle
//
//            return fragment
//        }

        //Or
        fun newInstance(text : String, number: Int) =
            ex_fragment().apply {
                arguments = Bundle().apply {
                    putString(ARGS_TEXT,text)
                    putInt(ARGS_NUMBER,number)
                }
            }
    }
}