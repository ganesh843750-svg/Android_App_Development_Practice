package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var input_num: TextView
    lateinit var ans: TextView
    lateinit var clear: Button
    lateinit var plus_operation: Button
    lateinit var diffrence: Button
    lateinit var product: Button
    lateinit var divid: Button
    lateinit var equal: Button
    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btn0: Button
    var input = StringBuilder()
    var number = 0
    var num1 = StringBuilder()
    var num2  = StringBuilder()
    var secondclick = false
    var results = 0.0
    var current_operator = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        input_num = findViewById(R.id.input_num)
        ans = findViewById(R.id.result)
        clear = findViewById(R.id.btn_clear)
        plus_operation = findViewById(R.id.btn_plus)
        diffrence = findViewById(R.id.btn_diffrence)
        product = findViewById(R.id.btn_product)
        divid = findViewById(R.id.btn_divid)
        equal = findViewById(R.id.btn_equal)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)



        btn0.setOnClickListener {
            number = 0
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn1.setOnClickListener {
            number = 1
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn2.setOnClickListener {
            number = 2
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn3.setOnClickListener {
            number = 3
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn4.setOnClickListener {
            number = 4
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn5.setOnClickListener {
            number = 5
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn6.setOnClickListener {
            number = 6
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn7.setOnClickListener {
            number = 7
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn8.setOnClickListener {
            number = 8
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        btn9.setOnClickListener {
            number = 9
            if (!secondclick){
                num1.append(number)
            }
            else num2.append(number)
            input.append(number)
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }

        plus_operation.setOnClickListener {
            if (!secondclick){
              results =  num1.toString().toDouble()
                current_operator = "+"
                secondclick = true
            }
            else{
               Calculate(num2.toString().toDouble(),current_operator)
                num1.clear()
                current_operator = "+"
                num2.clear()
            }

            input.append("+")
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        diffrence.setOnClickListener {
            if (!secondclick){
                results =  num1.toString().toDouble()
                num1.clear()
                current_operator = "-"
                secondclick = true
            }
            else{
                Calculate(num2.toString().toDouble(),current_operator)
                current_operator = "-"
                num2.clear()
            }
            input.append("-")
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE
        }
        product.setOnClickListener {
            if (!secondclick){
                results =  num1.toString().toDouble()
                num1.clear()
                current_operator = "x"
                secondclick = true
            }
            else{
                Calculate(num2.toString().toDouble(),current_operator)
                current_operator = "x"
                num2.clear()
            }

            input.append("x")
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE


        }
        divid.setOnClickListener {
            if (!secondclick){
                results =  num1.toString().toDouble()
                num1.clear()
                current_operator = "/"
                secondclick = true
            }
            else{
                Calculate(num2.toString().toDouble(),current_operator)
                current_operator = "/"
                num2.clear()
            }

            input.append("/")
            input_num.text = input.toString()
            input_num.visibility = View.VISIBLE


        }
        clear.setOnClickListener {
            input.clear()
            num1.clear()
            num2.clear()
            current_operator = ""
            results = 0.0
            secondclick = false
            input_num.visibility = View.INVISIBLE
            ans.visibility = View.INVISIBLE
        }
        equal.setOnClickListener {
            if (num2.isNotEmpty()){
                Calculate(num2.toString().toDouble(),current_operator)
                num2.clear()
            }
            ans.text = results.toString()
            ans.visibility = View.VISIBLE
        }



    }
    fun Calculate(num: Double,operator : String){
        when(operator){
            "+" -> results += num
            "-" -> results -= num
            "x" -> results *= num
            "/" -> results /= num
        }
    }

    }
