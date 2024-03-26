package com.example.homework_week3

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import net.objecthunter.exp4j.ExpressionBuilder
import androidx.appcompat.widget.SwitchCompat
import net.objecthunter.exp4j.operator.Operators

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var mSwitch: SwitchCompat = findViewById(R.id.switchMode)
        var btn0: Button = findViewById(R.id.btn0);
        var btn1: Button = findViewById(R.id.btn1);
        var btn2: Button = findViewById(R.id.btn2);
        var btn3: Button = findViewById(R.id.btn3);
        var btn4: Button = findViewById(R.id.btn4);
        var btn5: Button = findViewById(R.id.btn5);
        var btn6: Button = findViewById(R.id.btn6);
        var btn7: Button = findViewById(R.id.btn7);
        var btn8: Button = findViewById(R.id.btn8);
        var btn9: Button = findViewById(R.id.btn9);
        var btnAC: Button = findViewById(R.id.btnAC);
        var btnMinus: Button = findViewById(R.id.btnMinus);
        var btnPlus: Button = findViewById(R.id.btnPlus);
        var btnPlMn: Button = findViewById(R.id.btnPlMn);
        var btnN: Button = findViewById(R.id.btnN);
        var btnDivide: Button = findViewById(R.id.btnDivide);
        var btnPercent: Button = findViewById(R.id.btnPercent);
        var btnMul: Button = findViewById(R.id.btnMul);
        var btnEqual: Button = findViewById(R.id.btnEqual);
        var btnDot: Button = findViewById(R.id.btnDot);
        var btnDelete: ImageView = findViewById(R.id.delete);
        var btnHistory: ImageView = findViewById(R.id.history);
        var data: EditText = findViewById(R.id.data);
        var results: EditText = findViewById(R.id.results);
        var currentValue = ""

        mSwitch.setOnCheckedChangeListener { _, isChecked ->
            val backgroundText: LinearLayout = findViewById(R.id.main)
            val backgroundBody: LinearLayout = findViewById(R.id.body)
            val inputText: EditText = findViewById(R.id.data)
            val resultText: EditText = findViewById(R.id.results)
            if (isChecked) {
                backgroundText.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                backgroundBody.setBackgroundColor(ContextCompat.getColor(this, R.color.lightWhite))
                inputText.setTextColor(Color.BLACK)
                resultText.setTextColor(Color.BLACK)
            } else {
                backgroundText.setBackgroundColor(ContextCompat.getColor(this, R.color.light_green))
                backgroundBody.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                inputText.setTextColor(Color.WHITE)
                resultText.setTextColor(Color.WHITE)
            }
        }

        data.setHorizontallyScrolling(true);
        data.setSingleLine(true);
        btn1.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "1")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn1.text)
            }
        }

        btn2.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "2")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn2.text)
            }
        }
        btn3.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "3")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn3.text)
            }
        }
        btn4.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "4")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn4.text)
            }
        }
        btn5.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "5")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn5.text)
            }
        }
        btn6.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "6")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn6.text)
            }
        }
        btn7.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "7")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn7.text)
            }
        }
        btn8.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "8")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn8.text)
            }
        }
        btn9.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "9")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn9.text)
            }
        }
        btn0.setOnClickListener() {
            if (data.text.toString().startsWith("0")) {
                val newText = data.text.toString().replace("0", "0")
                data.setText(newText)
                data.setSelection(data.length())
            } else {
                data.append(btn0.text)
            }
        }

        btnDot.setOnClickListener {
            data.append(".")
            data.setSelection(data.length())
        }

        btnDelete.setOnClickListener {
            val text = data.text.toString();
            if (text.isNotEmpty()) {
                val updateText = text.substring(0, text.length - 1);
                data.setText(updateText);
                data.setSelection(updateText.length);
            }
        }

        btnAC.setOnClickListener {
            if (data.text.toString().isNotEmpty()) {
                data.setText("0")
                data.setSelection(1)
            }
            results.setText("= \n")
            results.setSelection(results.length())
        }

        var tinhToan: String = ""
        btnPlus.setOnClickListener {
            tinhToan = "+"
            data.append("+")
            data.setSelection(data.length())
        }

        btnMinus.setOnClickListener {
            tinhToan = "-"
            data.append("-")
            data.setSelection(data.length())
        }

        btnMul.setOnClickListener {
            tinhToan = "*"
            data.append("*")
            data.setSelection(data.length())
        }

        btnDivide.setOnClickListener {
            tinhToan = "/"
            data.append("/")
            data.setSelection(data.length())
        }
        btnPercent.setOnClickListener {
            tinhToan = "%"
            data.append("%")
            data.setSelection(data.length())
        }

        btnPlMn.setOnClickListener {

        }

        btnEqual.setOnClickListener {
            val input = data.text.toString()
            try {
                val result = ExpressionBuilder(input).build().evaluate()
                results.setText("= " + result.toString())
            } catch (e: Exception) {
                results.setText("Biểu thức không hợp lệ")
            }
        }
    }

    private fun calculate(expression: String): Double? {
        val numbers = expression.split("[+\\-*/%]".toRegex())
        val operators = expression.split("[0-9]+".toRegex()).filter { it.isNotEmpty() }

        if (numbers.size == operators.size + 1) {
            var result = numbers[0].toDouble()
            for (i in 0 until operators.size) {
                val operator = operators[i]
                val number = numbers[i + 1].toDouble()
                when (operator) {
                    "+" -> result += number
                    "-" -> result -= number
                    "*" -> result *= number
                    "/" -> result /= number
                    "%" -> result %= number
                }
            }
            return result
        }
        return null
    }

    private fun processOperator(l: Double, r: Double, operator: String): Double {
        return when (operator) {
            "+" -> l + r
            "-" -> l - r
            "x" -> l * r
            "/" -> l / r
            "%" -> l % r
            else -> Double.NaN
        }
    }

    private fun calculateV2(expression: String): Double {
        try {
            val numbers = expression.split("[+\\-*/%]".toRegex())
            val operators = expression.split("[0-9]+".toRegex()).filter { it.isNotEmpty() }
            var result = 0.0
            var i = 0
            while (i < numbers.size) {
                var tmp = numbers[i].toDouble()
                val j = i
                while (i + 1 < numbers.size && (operators[i + 1] == "x" || operators[i + 1] == "/")) {
                    i++
                    tmp = processOperator(tmp, numbers[i].toDouble(), operators[i])
                }
                result = processOperator(result, tmp, operators[j])
                i++
            }
            return result
        } catch (e: Exception) {
            return Double.NaN
        }
    }
}