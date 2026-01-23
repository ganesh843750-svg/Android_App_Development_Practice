package com.example.projecct_2_daily_choice_app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import android.widget.ToggleButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var dark: ToggleButton
    lateinit var hours: SeekBar
    lateinit var hours_text: TextView
    lateinit var java: CheckBox
    lateinit var kotlin: CheckBox
    lateinit var python: CheckBox
    lateinit var dsa: CheckBox
    lateinit var time: RadioGroup
    lateinit var submit: Button
    lateinit var layout: LinearLayout
    lateinit var tv: TextView

    object PrefKeys {// For implementation of shared prefrences
        const val DARK_MODE = "On"
        const val HOURS = "hours"
        const val SUBJECT = "subjects"
        const val TIME_SLOT = "time_slot"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        dark = findViewById(R.id.dark)
        hours = findViewById(R.id.hours)
        hours_text = findViewById(R.id.hours_text)
        java = findViewById(R.id.java)
        kotlin = findViewById(R.id.kotlin)
        python = findViewById(R.id.python)
        dsa = findViewById(R.id.dsa)
        time = findViewById(R.id.time)
        submit = findViewById(R.id.submit)
        layout = findViewById(R.id.main)
        tv = findViewById(R.id.tv)

        var study_hours: Int = 0
        var TimeSlot = " "
        val sharedpref = getSharedPreferences("Daily_choice_pref", MODE_PRIVATE)// step 1 : for shared prefrences
        val editor = sharedpref.edit()// step 2 : for shared prefrence is get editor through this
        // This is the implementation of Toggle button
        dark.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                layout.setBackgroundColor(getColor(R.color.black))
                editor.putBoolean(PrefKeys.DARK_MODE, true)
            } else {
                layout.setBackgroundColor(getColor(R.color.white))
                editor.putBoolean(PrefKeys.DARK_MODE, false)
            }
        }
        // this is the implementation of seekbar
        hours.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                when (progress) {
                    in 0..3 -> hours_text.text =
                        "Hours : $progress and very low Study time, Please Improve your Study Habit"

                    in 4..7 -> hours_text.text =
                        "Hours : $progress and Medium Study time, Good Study Habit"

                    in 8..12 -> hours_text.text =
                        "Hours : $progress and High Study time, Great Study"

                    in 13..17 -> hours_text.text =
                        "Hours : $progress and Very High Study time, Study Hard"

                    in 18..24 -> hours_text.text =
                        "Hours : $progress and Very Very High Study time, PLease Cocentrate on your health as well"
                }
                hours_text.visibility = View.VISIBLE
                study_hours = progress
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                hours_text.visibility = View.VISIBLE

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                hours_text.visibility = View.VISIBLE

            }
        })


        submit.setOnClickListener {
            val subjects = StringBuilder()
            // this builds a string and uppends the subjects which are checked
            subjects.append("Subjects : \n")
            if (java.isChecked) subjects.append("-" + java.text.toString() + "\n")
            if (kotlin.isChecked) subjects.append("-" + kotlin.text.toString() + "\n")
            if (python.isChecked) subjects.append("-" + python.text.toString() + "\n")
            if (dsa.isChecked) subjects.append("-" + dsa.text.toString() + "\n")
            val checkedId = time.checkedRadioButtonId
            if (checkedId != -1) {
                val radioButton = findViewById<RadioButton>(checkedId)
                TimeSlot = radioButton.text.toString()
            } else TimeSlot = "No Time Slot Selected"

            // This is for intent passing and data passing through intents you can uncomment it to check
            val intent = Intent(this@MainActivity, Your_plan::class.java)
//            intent.putExtra(data.sub, subjects.toString())
//            intent.putExtra(data.time_slot, TimeSlot)
//            intent.putExtra(data.hours_text, study_hours)


            // step 3 : for shared prefrences is Storing data through editor
            editor.putInt(PrefKeys.HOURS, study_hours)
            editor.putString(PrefKeys.TIME_SLOT, TimeSlot)
            editor.putString(PrefKeys.SUBJECT, subjects.toString())
            editor.apply()
            startActivity(intent)

        }

        // This is for navigating back from Second activity to this activity i.e first activity
        val getResult =
            registerForActivityResult(androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()) {
                if (it.resultCode == data.RESULT_CODE) {
                    val message = it.data!!.getStringExtra(data.GO_BACK)
                    tv.text = message.toString()// this displays the message recieved from seconf activity
                    tv.visibility = View.VISIBLE

                }

            }
        getResult.launch(intent)//this is for navigation from second activity to this activity and getting result
    }

}

//This folloving class is for intent passing with data and values inside it are keys for data passing through intents
class data {
    companion object {
        const val sub = "Subjects"
        const val time_slot = "Time slot"
        const val hours_text = "Hours"
        const val RESULT_CODE = 123123
        const val GO_BACK = "Go Back"
    }
}