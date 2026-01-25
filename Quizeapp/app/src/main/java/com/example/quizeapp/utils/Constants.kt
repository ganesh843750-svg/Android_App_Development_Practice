package com.example.quizeapp.utils

import com.example.quizeapp.R
import com.example.quizeapp.model.Qustions

object Constants{
    const val USER_NAME = "user_name"
    const val  TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getQuestions(): MutableList<Qustions>{
        val qustions = mutableListOf<Qustions>()
        val Q1 = Qustions(
            1,"What Country does this flag belong ?",
            R.drawable.italy_flag,
            "Italy Flag","India Flag","Iran Flag","Ireland Flag",
            1
        )
        qustions.add(Q1)

        val Q2 = Qustions(
            2,"What Country does this flag belong ?",
            R.drawable.indian_flag,
            "Italy Flag","Indian Flag","Iran Flag","Ireland Flag",
            2
        )
        qustions.add(Q2)

        val Q3 = Qustions(
            3,"What Country does this flag belong ?",
            R.drawable.romania_flag,
            "Italy Flag","India Flag","Romania Falg","Ireland Flag",
            3
        )
        qustions.add(Q3)

        val Q4 = Qustions(
            4,"What Country does this flag belong ?",
            R.drawable.spain_flag,
            "Spain Flag","India Flag","Iran Flag","Ireland Flag",
            1
        )
        qustions.add(Q4)

        val Q5 = Qustions(
            5,"What Country does this flag belong ?",
            R.drawable.nigeria_flag,
            "Italy Flag","India Flag","Iran Flag","Nigeria Flag",
            4
        )
        qustions.add(Q5)

        val Q6 = Qustions(
            6,"What Country does this flag belong ?",
            R.drawable.france_falg,
            "Italy Flag","France Flag","Iran Flag","Ireland Flag",
            2
        )
        qustions.add(Q6)

        val Q7 = Qustions(
            7,"What Country does this flag belong ?",
            R.drawable.finland_flag,
            "Finland Flag","India Flag","Iran Flag","Ireland Flag",
            1
        )
        qustions.add(Q7)

        val Q8 = Qustions(
            8,"What Country does this flag belong ?",
            R.drawable.brezil_falg,
            "Italy Flag","India Flag","Brazil Flag","Ireland Flag",
            3
        )
        qustions.add(Q8)

        val Q9 = Qustions(
            9,"What Country does this flag belong ?",
            R.drawable.germany_flag,
            "Italy Flag","India Flag","Iran Flag","Germany Flag",
            4
        )
        qustions.add(Q9)

        val Q10 = Qustions(
            10,"What Country does this flag belong ?",
            R.drawable.argentina_flag,
            "Italy Flag","Argentina Flag","Iran Flag","Ireland Flag",
            2
        )
        qustions.add(Q10)

        return qustions

    }

}