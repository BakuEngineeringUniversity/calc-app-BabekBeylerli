package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var textViewDisplay: TextView
    private var firstNumber: Double = 0.0
    private var secondNumber: Double = 0.0
    private var currentOperator: String = ""

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewDisplay = findViewById(R.id.textViewDisplay)


        val numberClickListener = View.OnClickListener { view ->
            val buttonText = (view as Button).text.toString()
            val currentText = textViewDisplay.text.toString()
            textViewDisplay.text = currentText + buttonText
        }

        findViewById<Button>(R.id.button0).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button1).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button2).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button3).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button4).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button5).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button6).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button7).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button8).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.button9).setOnClickListener(numberClickListener)
        findViewById<Button>(R.id.buttonDot).setOnClickListener(numberClickListener)

        findViewById<Button>(R.id.buttonPlus).setOnClickListener { setOperator("+") }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { setOperator("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { setOperator("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { setOperator("/") }

        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calculate() }
        findViewById<Button>(R.id.buttonDelete).setOnClickListener {
            textViewDisplay.text = "0"
            firstNumber = 0.0
            secondNumber = 0.0
            currentOperator = ""
        }

    }

    private fun setOperator(operator: String) {
        currentOperator = operator
        val currentText = textViewDisplay.text.toString()
        firstNumber = currentText.toDouble()
        textViewDisplay.text = ""
    }

    private fun calculate() {
        val secondText = textViewDisplay.text.toString()
        secondNumber = secondText.toDouble()
        var result = 0.0
        when (currentOperator) {
            "+" -> result = firstNumber + secondNumber
            "-" -> result = firstNumber - secondNumber
            "*" -> result = firstNumber * secondNumber
            "/" -> {
                if (secondNumber != 0.0) {
                    result = firstNumber / secondNumber
                } else {
                    // Sıfıra bölme hatası
                    textViewDisplay.text = "Error"
                    return
                }
            }
        }
        textViewDisplay.text = result.toString()
    }
}