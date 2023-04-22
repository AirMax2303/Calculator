package Dev.JahidHasanCo.calculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import org.mariuszgromada.math.mxparser.Expression
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        var resultt: String
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM)

        button_clear.setOnClickListener {
            input.text = ""
            output.text = ""
            input2.text = ""
        }

        button_bracket.setOnClickListener {

            //input.text = addToInputText("(")
            input2.text = addToInput2Text("(")

        }
        button_bracket_r.setOnClickListener {

            //input.text = addToInputText(")")
            input2.text = addToInput2Text(")")

        }

        button_croxx.setOnClickListener {
            val removedLast = input.text.toString().dropLast(1)
            //input.text = removedLast
            input2.text = removedLast
        }

        button_0.setOnClickListener {
            //input.text = addToInputText("0")
            input2.text = addToInput2Text("0")
        }
        button_1.setOnClickListener {
            //input.text = addToInputText("1")
            input2.text = addToInput2Text("1")
        }
        button_2.setOnClickListener {
            //input.text = addToInputText("2")
            input2.text = addToInput2Text("2")
        }
        button_3.setOnClickListener {
            //input.text = addToInputText("3")
            input2.text = addToInput2Text("3")
        }
        button_4.setOnClickListener {
            //input.text = addToInputText("4")
            input2.text = addToInput2Text("4")
        }
        button_5.setOnClickListener {
            //input.text = addToInputText("5")
            input2.text = addToInput2Text("5")
        }
        button_6.setOnClickListener {
            //input.text = addToInputText("6")
            input2.text = addToInput2Text("6")
        }
        button_7.setOnClickListener {
            //input.text = addToInputText("7")
            input2.text = addToInput2Text("7")
        }
        button_8.setOnClickListener {
            //input.text = addToInputText("8")
            input2.text = addToInput2Text("8")
        }
        button_9.setOnClickListener {
            //input.text = addToInputText("9")
            input2.text = addToInput2Text("9")
        }
        button_dot.setOnClickListener {
            //input.text = addToInputText(".")
            input2.text = addToInput2Text(".")
        }
        button_division.setOnClickListener {
            if (input.text.toString() == "") {
                input.text = addToInputText("÷") // ALT + 0247
                output.text = input2.text
                input2.text = ""
            } else if (input.text.toString() != "÷") {
                input.text = ""
                input.text = addToInputText("÷") // ALT + 0247
            }

        }
        button_multiply.setOnClickListener {
            if (input.text.toString() == "") {
                input.text = addToInputText("×") // ALT + 0215
                output.text = input2.text
                input2.text = ""
            } else if (input.text.toString() != "×") {
                input.text = ""
                input.text = addToInputText("×") // ALT + 0215
            }
        }

        button_subtraction.setOnClickListener {
            if (input.text.toString() == "") {
                input.text = addToInputText("-")
                output.text = input2.text
                input2.text = ""
            } else if (input.text.toString() != "-") {
                input.text = ""
                input.text = addToInputText("-")
            }

        }
        button_addition.setOnClickListener {
            if (input.text.toString() == "") {
                input.text = addToInputText("+")
                output.text = input2.text
                input2.text = ""
            } else if (input.text.toString() != "+") {
                input.text = ""
                input.text = addToInputText("+")
            }
        }

        button_equals.setOnClickListener {
            showResult()
        }
    }

    private fun addToInputText(buttonValue: String): String {

        return input.text.toString() + "" + buttonValue
    }

    private fun addToInput2Text(buttonValue: String): String {

        return input2.text.toString() + "" + buttonValue
    }

    @SuppressLint("SetTextI18n")
    private fun getInputExpression(): String {
        //var ouputText = output.text
        //var inputText = input.text
        var resultt = ""
        input2.text = output.text.toString() + input.text.toString() + input2.text.toString()
        //resultt.plus(output.text.toString())
        //resultt.plus(input.text.toString())
        //resultt.plus(input2.text.toString())

        var expression = input2.text.replace(Regex("÷"), "/")
        expression = expression.replace(Regex("×"), "*")
        return expression
    }

    private fun showResult() {
        try {
            val expression = getInputExpression()
            val result = Expression(expression).calculate()
            if (result.isNaN()) {
                // Show Error Message
                //output.text = ""
                //input2.text = ""
                output.setTextColor(ContextCompat.getColor(this, R.color.blue))
            } else {
                // Show Result
                input2.text = DecimalFormat("0.######").format(result).toString()
                input2.setTextColor(ContextCompat.getColor(this, R.color.green))
                input.text = ""
                output.text = ""
            }
        } catch (e: Exception) {
            // Show Error Message
            output.text = e.toString()
            output.setTextColor(ContextCompat.getColor(this, R.color.red))
        }
    }
}