package my.ren.bmiCalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Linking UI to Program
        val imageViewBMI:ImageView = findViewById(R.id.imageViewBMI)
        val textViewBMI : TextView = findViewById(R.id.textViewBMI)
        val editTextWeight : EditText = findViewById(R.id.editTextWeight)
        val editTextHeight : EditText = findViewById(R.id.editTextHeight)
        val buttonCalculate : Button = findViewById(R.id.buttonCalculate)
        val buttonReset : Button = findViewById(R.id.buttonReset)

        buttonCalculate.setOnClickListener {
            //Getting input from the user
            if (editTextWeight.text.isEmpty()){
                editTextWeight.setError(getString(R.string.value_required))
                return@setOnClickListener // end program
            }

            val weight = editTextWeight.text.toString().toFloat()



            val height = editTextHeight.text.toString().toFloatOrNull()
            if (height == null) {
                editTextHeight.setError(getString(R.string.value_required))
                return@setOnClickListener
            }

            val bmi = weight/ (height/100).pow(2)
            //Underweight = <18.5
            //Normal weight = 18.5–24.9
            //Overweight = 25–29.9
            if (bmi<18.5)
            {
                imageViewBMI.setImageResource(R.drawable.under)
                textViewBMI.text = String.format("%s %s %.2f", getString(R.string.bmi),
                getString(R.string.underweight),bmi)
            }

            else if (bmi >= 18.5 && bmi <=24.9)
            {
                imageViewBMI.setImageResource(R.drawable.normal)
                textViewBMI.text = String.format("%s %s %.2f", getString(R.string.bmi),
                    getString(R.string.normal),bmi)
            }

            else
            {
                imageViewBMI.setImageResource(R.drawable.over)
                textViewBMI.text = String.format("%s %s %.2f", getString(R.string.bmi),
                    getString(R.string.overweight),bmi)
            }




        } /// end of button 1

        buttonReset.setOnClickListener {

        }


    }
}