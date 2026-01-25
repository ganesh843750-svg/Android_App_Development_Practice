package com.example.quizeapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.quizeapp.R
import com.example.quizeapp.model.Qustions
import com.example.quizeapp.utils.Constants
import com.example.quizeapp.utils.Result_Activity

class Qustions_Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressBar: ProgressBar
    private lateinit var textViewProgress: TextView
    private lateinit var textViewQustion: TextView
    private lateinit var flagImage : ImageView
    private lateinit var tv_option_one : TextView
    private lateinit var tv_option_two : TextView
    private lateinit var tv_option_three : TextView
    private lateinit var tv_option_four : TextView

    private var QustionCounter = 0
    private lateinit var questionList : MutableList<Qustions>

    private var selected_Ansuwer = 0
    private lateinit var currentQustion : Qustions

    private var ansuwered = false
    private lateinit var check_btn : Button
    private lateinit var userName : String
    private var score = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_qustions)

        progressBar = findViewById(R.id.progressBar)
        textViewProgress = findViewById(R.id.text_view_progrss)
        textViewQustion = findViewById(R.id.questions_text_view)
        flagImage = findViewById(R.id.image_flag)
        check_btn = findViewById(R.id.btn_check)

        tv_option_one = findViewById(R.id.text_View_option_one)
        tv_option_two = findViewById(R.id.text_View_option_two)
        tv_option_three = findViewById(R.id.text_View_option_three)
        tv_option_four = findViewById(R.id.text_View_option_four)

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        check_btn.setOnClickListener(this)


        questionList = Constants.getQuestions()
        Log.d("QstionSize", " ${questionList.size}")
        ShowNextQuestion()
        if (intent.hasExtra(Constants.USER_NAME)){
            userName = intent.getStringExtra(Constants.USER_NAME)!!

        }
    }
    private fun ShowNextQuestion() {

        if (QustionCounter < questionList.size){
            currentQustion = questionList[QustionCounter]
            check_btn.text = "CHECK"
            resetoptions()
            val question = questionList[QustionCounter]
            currentQustion = questionList[QustionCounter]
            flagImage.setImageResource(question.image)
            progressBar.progress = QustionCounter + 1
            textViewProgress.text = "${QustionCounter + 1 }/${progressBar.max}"
            textViewQustion.text = question.qustion
            tv_option_one.text = question.optionOne
            tv_option_two.text = question.optiontwo
            tv_option_three.text = question.optionthree
            tv_option_four.text = question.optionfour

        }
        else{
            check_btn.text = "FINISH"

            Intent(this, Result_Activity::class.java).also {
                it.putExtra(Constants.USER_NAME,userName)
                it.putExtra(Constants.TOTAL_QUESTIONS,questionList.size)
                it.putExtra(Constants.CORRECT_ANSWERS,score)
                startActivity(it)
            }
        }


        QustionCounter++
        ansuwered = false


    }
    private fun resetoptions(){
        val options = mutableListOf<TextView>()
        options.add(tv_option_one)
        options.add(tv_option_two)
        options.add(tv_option_three)
        options.add(tv_option_four)
        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_bg)
        }
    }


    private fun selectedoption(textView: TextView,selected_option_num : Int){
        resetoptions()
        selected_Ansuwer = selected_option_num
        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD)
        textView.background = ContextCompat.getDrawable(this,R.drawable.selected_option_bg)

    }

    override fun onClick(v: View?) {
       when(v?.id){
           R.id.text_View_option_one ->{
               selectedoption(tv_option_one,1)
           }
           R.id.text_View_option_two ->{
               selectedoption(tv_option_two,2)
           }
           R.id.text_View_option_three ->{
               selectedoption(tv_option_three,3)
           }
           R.id.text_View_option_four ->{
               selectedoption(tv_option_four,4)
           }
           R.id.btn_check -> {
               if(!ansuwered){
                   checkAnsuwer()

               }
               else{
                   resetoptions()
                   ShowNextQuestion()


               }
               selected_Ansuwer = 0

           }

       }
    }
    private fun checkAnsuwer () {
        ansuwered = true


        if (selected_Ansuwer == currentQustion.correctAnswer) {
            score++
            when (selected_Ansuwer) {
                1 -> {
                    tv_option_one.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
                }

                2 -> {
                    tv_option_two.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
                }

                3 -> {
                    tv_option_three.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
                }

                4 -> {
                    tv_option_four.background =
                        ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
                }

            }

        } else {
            when (selected_Ansuwer) {
                1 -> {
                    tv_option_one.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_bg)
                }

                2 -> {
                    tv_option_two.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_bg)
                }

                3 -> {
                    tv_option_three.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_bg)
                }

                4 -> {
                    tv_option_four.background =
                        ContextCompat.getDrawable(this, R.drawable.wrong_option_bg)
                }
            }
        }
        check_btn.text = "NEXT"
        showSolution()
    }

    private fun showSolution(){
        selected_Ansuwer = currentQustion.correctAnswer
        when (selected_Ansuwer) {
            1 -> {
                tv_option_one.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
            }

            2 -> {
                tv_option_two.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
            }

            3 -> {
                tv_option_three.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
            }

            4 -> {
                tv_option_four.background =
                    ContextCompat.getDrawable(this, R.drawable.correct_option_bg)
            }
        }
    }


}