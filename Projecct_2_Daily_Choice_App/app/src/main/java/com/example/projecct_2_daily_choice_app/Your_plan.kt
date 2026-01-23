package com.example.projecct_2_daily_choice_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.PickVisualMediaRequest
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class Your_plan : AppCompatActivity() {
    lateinit var hours : TextView
    lateinit var subjects : TextView
    lateinit var time : TextView
    lateinit var layout : LinearLayout
    lateinit var btn_back : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_your_plan)
        hours = findViewById(R.id.hours_text)
        subjects = findViewById(R.id.subjects_text)
        time = findViewById(R.id.time_text)
        layout = findViewById(R.id.main)
        btn_back = findViewById(R.id.btnback)
        // This is for the implementation of shared prefrences
        val sharedPref   = getSharedPreferences("Daily_choice_pref",MODE_PRIVATE)
        // This are the values which are stored in shared prefrences and we get it using getINt or getString functions based on the values
        val HOUR = sharedPref.getInt(MainActivity.PrefKeys.HOURS,0)
        val SUB = sharedPref.getString(MainActivity.PrefKeys.SUBJECT,"Subjects")
        val timeslot = sharedPref.getString(MainActivity.PrefKeys.TIME_SLOT,"No Time Slot")
        val MODE = sharedPref.getBoolean(MainActivity.PrefKeys.DARK_MODE,false)
        if (MODE) layout.setBackgroundColor(getColor(R.color.black))
        else layout.setBackgroundColor(getColor(R.color.white))

        // This changes the background color based on the study hours
        if (HOUR <= 3) layout.setBackgroundColor(getColor(R.color.red))
        else if(HOUR in 4..7) layout.setBackgroundColor(getColor(R.color.orange))
        else if( HOUR in 8..12) layout.setBackgroundColor(getColor(R.color.green))
        else if( HOUR in 13..17) layout.setBackgroundColor(getColor(R.color.orange))
        else layout.setBackgroundColor(getColor(R.color.red))

        // This displayes data we got from shared prefrences
        hours.text = "Hours :  \n" + HOUR.toString()
        subjects.text = SUB.toString()
        time.text = "Time Slot : \n" + timeslot.toString()
        



            // This is for implementation of data passing through intents. You can uncomment it and check
//        val plan = intent.extras
//        plan?.let {
//            hours.text ="Hours : " +  plan.getInt(data.hours_text).toString()
//            subjects.text = plan.getString(data.sub).toString()
//            time.text = "Time Sloat : \n" + plan.getString(data.time_slot).toString()



//            if (plan.getInt(data.hours_text) <= 3) layout.setBackgroundColor(getColor(R.color.red))
//            else if( plan.getInt(data.hours_text) in 4..7) layout.setBackgroundColor(getColor(R.color.orange))
//            else if( plan.getInt(data.hours_text) in 8..12) layout.setBackgroundColor(getColor(R.color.green))
//            else if( plan.getInt(data.hours_text) in 13..17) layout.setBackgroundColor(getColor(R.color.orange))
//                else layout.setBackgroundColor(getColor(R.color.red))
            // This macks text view visoble
            hours.visibility = View.VISIBLE
            subjects.visibility = View.VISIBLE
            time.visibility = View.VISIBLE

        // This is for navigating back from Second activity to this activity i.e first activity and sending data through intent

        btn_back.setOnClickListener {
            val intent = Intent(this@Your_plan, MainActivity::class.java)
            intent.putExtra(data.GO_BACK, "Please Customize Your Plan Again ")
            setResult(data.RESULT_CODE,intent)
            finish()
        }
    }

        }