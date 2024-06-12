package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Retrieve the components EditText
        // Create a variable and associate (=) the UI<EditText> component
        // Recover the screen button

        // Put action on the button setOnClickListener
        // Recover the text typed in edtWeight

        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)

        val btnCalculate = findViewById<Button>(R.id.btn_calculate)


        btnCalculate.setOnClickListener {

        val weightStr: String = edtWeight.text.toString()
        val heightStr: String = edtHeight.text.toString()

 validate_empty_field
        if(weightStr == "" || heightStr == ""){
        //Show message to user

        println("Button action" + result)
 master

            Snackbar
                .make(
                    edtWeight,
                    "Fill in all the fields",
                    Snackbar.LENGTH_LONG
                ).show()
        }else{
            val weight = weightStr.toFloat()
            val height = heightStr.toFloat()

            val heightQ2 = height * height
            val result = weight / heightQ2


            println("Button action" + result)
        }
        }
    }
}
