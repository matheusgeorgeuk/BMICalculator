package com.comunidadedevspace.imc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_RESULT_BMI = "ResultActivity.KEY_BMI"

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_BMI, 0f)

        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)
        tvResult.text = result.toString()

        var (classification: String , color: Int) = when {
            result <= 18.5f -> {
                "UNDERWEIGHT" to R.color.underweight
            }

            result > 18.5f && result <= 24.9f -> {
                "NORMAL" to R.color.normal
            }

            result > 25f && result <= 29.9f -> {
                "OVERWEIGHT" to R.color.overweight
            }

            result > 30f && result <= 39.9f -> {
                "OBESITY" to R.color.obesity
            }

            else -> {
                "SEVERE OBESITY" to R.color.severe_obesity
            }
        }

        tvClassification.setTextColor(ContextCompat.getColor(this, color))

        tvClassification.text = classification


    }
}