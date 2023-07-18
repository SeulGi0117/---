package com.example.calculation_app

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
            viewNum = tvResult
        }

        var num1 = "0"
        var num2 = "0"

        zero.setOnClickListener{
            num1 = num1 + "0"
            viewNum.setText(num1)
        }
        one.setOnClickListener{
            num1 = num1 + "1"
            viewNum.setText(num1)
        }
        two.setOnClickListener{
            num1 = num1 + "2"
            viewNum.setText(num1)
        }
        three.setOnClickListener{
            num1 = num1 + "3"
            viewNum.setText(num1)
        }
        four.setOnClickListener{
            num1 = num1 + "4"
            viewNum.setText(num1)
        }
        five.setOnClickListener{
            num1 = num1 + "5"
            viewNum.setText(num1)
        }
        six.setOnClickListener{
            num1 = num1 + "6"
            viewNum.setText(num1)
        }
        seven.setOnClickListener{
            num1 = num1 + "7"
            viewNum.setText(num1)
        }
        eight.setOnClickListener{
            num1 = num1 + "8"
            viewNum.setText(num1)
        }
        nine.setOnClickListener{
            num1 = num1 + "9"
            viewNum.setText(num1)
        }

        plus.setOnClickListener {
            num2 = (num2.toInt() + num1.toInt()).toString()
            num1 = "0"
            viewNum.setText(num2)
        }

        minus.setOnClickListener {
            num2 = (num2.toInt() - num1.toInt()).toString()
            num1= "0"
            viewNum.setText(num2)
        }

        clear.setOnClickListener {
            num1 = "0"
            num2 = "0"
            viewNum.setText("0")
        }

        result.setOnClickListener{

        }



    }
}
