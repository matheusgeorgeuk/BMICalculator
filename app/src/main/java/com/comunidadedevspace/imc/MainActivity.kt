package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
        val weight: Float = edtWeight.text.toString().toFloat()
        val height: Float = edtHeight.text.toString().toFloat()

        val heightQ2 = height * height
        val result = weight / heightQ2

        println("Button action" + result)

        }
    }
}
