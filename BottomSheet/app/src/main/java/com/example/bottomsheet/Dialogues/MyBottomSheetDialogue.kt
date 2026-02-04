package com.example.bottomsheet.Dialogues

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.bottomsheet.R

import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MyBottomSheetDialogue :  BottomSheetDialogFragment(){
    private lateinit var listener : BottomSheetListener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_layout,container,false)
        val btn1 = view.findViewById<Button>(R.id.btn1)
        val btn2 = view.findViewById<Button>(R.id.btn2)
        btn1.setOnClickListener {
            listener.onButtonClicked("Button 1 Clicked")
            dismiss()

        }
        btn2.setOnClickListener {

            listener.onButtonClicked("Button 2 Clicked")
            dismiss()
        }
return view
    }
    interface BottomSheetListener{
        fun onButtonClicked(text : String)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is BottomSheetListener){
            listener = context
        }
        else throw RuntimeException(context.toString() + "You must implement BottomSheetListener")
    }


}