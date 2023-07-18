package com.example.calculation_app

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.calculation_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var zero: Button
    private lateinit var one: Button
    private lateinit var two: Button
    private lateinit var three: Button
    private lateinit var four: Button
    private lateinit var five: Button
    private lateinit var six: Button
    private lateinit var seven: Button
    private lateinit var eight: Button
    private lateinit var nine: Button
    private lateinit var plus: Button
    private lateinit var minus: Button
    private lateinit var div: Button
    private lateinit var mul: Button
    private lateinit var result: Button
    private lateinit var clear: Button
    private lateinit var viewNum: TextView
    private lateinit var resultNum: TextView

    private var num1 = ""
    private var num2 = ""
    private var operator = ""
    private var previousButton: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            zero = button0
            one = button1
            two = button2
            three = button3
            four = button4
            five = button5
            six = button6
            seven = button7
            eight = button8
            nine = button9
            plus = buttonPlus
            minus = buttonMinus
            div = buttonDiv
            mul = buttonMul
            result = buttonResult
            clear = buttonAc
            viewNum = tvNum
            resultNum = tvResult
        }



        zero.setOnClickListener{
            appendNumber("0")
        }
        one.setOnClickListener{
            appendNumber("1")
        }
        two.setOnClickListener{
            appendNumber("2")
        }
        three.setOnClickListener{
            appendNumber("3")
        }
        four.setOnClickListener{
            appendNumber("4")
        }
        five.setOnClickListener{
            appendNumber("5")
        }
        six.setOnClickListener{
            appendNumber("6")
        }
        seven.setOnClickListener{
            appendNumber("7")
        }
        eight.setOnClickListener{
            appendNumber("8")
        }
        nine.setOnClickListener{
            appendNumber("9")
        }

        plus.setOnClickListener {
            setOperator("+", plus)
        }
        minus.setOnClickListener {
            setOperator("-", minus)
        }

        div.setOnClickListener {
            setOperator("/", div)
        }
        mul.setOnClickListener {
            setOperator("*", mul)
        }

        clear.setOnClickListener {
            clearCalculation()
            resetButtonColors()
        }

        result.setOnClickListener{
            performCalculation()
            resetButtonColors()
        }
    }

    private fun appendNumber(number: String) {
        if(operator.isEmpty()) {
            num1+=number
            viewNum.text = num1
        } else {
            num2 += number
            viewNum.text = num2
        }
    }

    private fun setOperator(op: String, button: Button){
        if (num1.isNotEmpty() && num2.isEmpty()) {
            operator = op

            previousButton?.let {
                resetButtonColor(it)
            }

            // 버튼의 색상 변경
            setButtonColor(button)
            previousButton = button
        }
    }

    private fun performCalculation() {
        if (num1.isNotEmpty() && num2.isNotEmpty()) {
            val result = when (operator) {
                "+" -> num1.toInt() + num2.toInt()
                "-" -> num1.toInt() - num2.toInt()
                "*" -> num1.toInt() * num2.toInt()
                "/" -> num1.toInt() / num2.toInt()
                else -> 0
            }
            resultNum.text = result.toString()
        }
    }
    private fun clearCalculation() {
        num1 = ""
        num2 = ""
        operator = ""
        viewNum.text ="0"
        resultNum.text = ""
    }

    private fun setButtonColor(button: Button) {
        button.setBackgroundColor(Color.WHITE)
        button.setTextColor(Color.parseColor("#FF9800"))
    }

    private fun resetButtonColor(button: Button) {
        button.setBackgroundColor(Color.parseColor("#FF9800"))
        button.setTextColor(Color.WHITE)
    }
    private fun resetButtonColors() {
        plus.setBackgroundColor(Color.parseColor("#FF9800"))
        plus.setTextColor(Color.WHITE)
        minus.setBackgroundColor(Color.parseColor("#FF9800"))
        minus.setTextColor(Color.WHITE)
        div.setBackgroundColor(Color.parseColor("#FF9800"))
        div.setTextColor(Color.WHITE)
        mul.setBackgroundColor(Color.parseColor("#FF9800"))
        mul.setTextColor(Color.WHITE)

        previousButton?.let {
            resetButtonColor(it)
            previousButton = null
        }
    }
}
