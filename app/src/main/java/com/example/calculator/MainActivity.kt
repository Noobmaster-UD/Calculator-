package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //setting number values
        val zero = findViewById<Button>(R.id.zeroBTN)
        val one = findViewById<Button>(R.id.oneBTN)
        val two = findViewById<Button>(R.id.twoBTN)
        val three = findViewById<Button>(R.id.threeBTN)
        val four = findViewById<Button>(R.id.fourBTN)
        val five = findViewById<Button>(R.id.fiveBTN)
        val six = findViewById<Button>(R.id.sixBTN)
        val seven = findViewById<Button>(R.id.sevenBTN)
        val eight = findViewById<Button>(R.id.eightBTN)
        val nine = findViewById<Button>(R.id.nineBTN)
        //setting operation values
        val clear  = findViewById<Button>(R.id.clearBTN)
        val open = findViewById<Button>(R.id.openBTN)
        val close = findViewById<Button>(R.id.closeBTN)
        val exponent = findViewById<Button>(R.id.exponentBTN)
        val divide = findViewById<Button>(R.id.divideBTN)
        val multiply = findViewById<Button>(R.id.multiplyBTN)
        val subtract = findViewById<Button>(R.id.subtractBTN)
        val add = findViewById<Button>(R.id.addBTN)
        val equals = findViewById<Button>(R.id.equalsBTN)
        val point = findViewById<Button>(R.id.pointBTN)
        val backspace = findViewById<ImageButton>(R.id.backspace)

        val display = findViewById<TextView>(R.id.textView)
        val answerText = findViewById<TextView>(R.id.answerText)

        // variables
        var string1 = ""
        var string2 = ""


        //onClickListeners
        //numbers
        zero.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            if(string1 != "0"){
                string1 += "0"
            }
            display.text = string1
        }
        one.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "1"
            display.text = string1
        }
        two.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "2"
            display.text = string1
        }
        three.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "3"
            display.text = string1
        }
        four.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "4"
            display.text = string1
        }
        five.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "5"
            display.text = string1
        }
        six.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "6"
            display.text = string1
        }
        seven.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "7"
            display.text = string1
        }
        eight.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "8"
            display.text = string1
        }
        nine.setOnClickListener {
            if(string1.isNotEmpty() && string1.last()==')'){
                string1 += '×'
            }
            string1 += "9"
            display.text = string1
        }
        point.setOnClickListener {
            if(string1.isNotEmpty()&&(string1.last()<='0'||string1.last()>='9')){
                string1 = string1.dropLast(1)
            }
            else if(string1.isEmpty()){
                string1 += '0'
            }
            if(string1.last()!='('&&string1.last()!=')'&&string1.last()!='.') {
                string1 += "."
            }
            display.text = string1
        }

        //clear button
        clear.setOnClickListener {
            string1 = ""
            string2 = ""
            display.text = string1
            answerText.text = string2
        }

        //BODMAS/equals/delete
        open.setOnClickListener {
            if(string1.isNotEmpty()&&(string1.last()>='0'&&string1.last()<='9')){
                string1 += '×'
            }
            string1 += '('
            display.text = string1
        }
        close.setOnClickListener {
            if(string1.isNotEmpty()&&string1.last()!=')'&&(string1.last()<'0'||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            if(string1.isNotEmpty()) {
                string1 += ')'
            }
            display.text = string1
        }
        exponent.setOnClickListener {
            if(string1.isNotEmpty()&&((string1.last()<'0'&&string1.last()!=')')||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            if(string1.isNotEmpty()&&string1.last()!='(') {
                string1 += '^'
            }
            display.text = string1
        }
        divide.setOnClickListener {
            if(string1.isNotEmpty()&&((string1.last()<'0'&&string1.last()!=')')||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            if(string1.isNotEmpty()&&string1.last()!='(') {
                string1 += '÷'
            }
            display.text = string1
        }
        multiply.setOnClickListener {
            if(string1.isNotEmpty()&&((string1.last()<'0'&&string1.last()!=')')||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            if(string1.isNotEmpty()&&string1.last()!='(') {
                string1 += '×'
            }
            display.text = string1
        }
        subtract.setOnClickListener {
            if(string1.isNotEmpty()&&((string1.last()<'0'&&string1.last()!=')')||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            string1 += '-'
            display.text = string1
        }
        add.setOnClickListener {
            if(string1.isNotEmpty()&&((string1.last()<'0'&&string1.last()!=')')||string1.last()>'9')){
                string1 = string1.dropLast(1)
            }
            if(string1.isNotEmpty()&&string1.last()!='(') {
                string1 += "+"
                display.text = string1
            }
        }
        backspace.setOnClickListener {
            string1 = string1.dropLast(1)
            display.text = string1
        }
        backspace.setOnLongClickListener {
            string1 = ""
            string2 = ""
            display.text = string1
            answerText.text = string2
            return@setOnLongClickListener true
        }
        equals.setOnClickListener {
            //replacing chars ×->*  and ÷->/
            string2 = string1
            string2 = string2.replace('×','*')
            string2 = string2.replace('÷','/')
            val exp = Expression(string2)
            answerText.text = exp.calculate().toString()
            display.text = string1
        }
    }
}
