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

        val tvDescription = findViewById<TextView>(R.id.tv_description)

        val (classification: String, color: Int) = when {
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

        val description: String = when {
            result <= 18.5f -> {
                "Being below the ideal weight can be more dangerous to health than obesity, regardless of other risk factors. According to research, the risk of death is 80% higher in underweight individuals compared to those with a healthy weight. Additionally, malnutrition, weak bones, and a compromised immune system are some of the consequences of being underweight."
            }

            result > 18.5f && result <= 24.9f -> {
                "Being at the ideal weight brings several benefits to health and well-being. Additionally, maintaining this weight is essential for preventing diseases and ensuring a healthier life. Keep a healthy diet and exercise regularly to stay at the appropriate weight."
            }

            result > 25f && result <= 29.9f -> {
                "Being overweight, according to the Body Mass Index (BMI), poses significant health risks. In addition to affecting quality of life, excess weight is associated with several serious conditions, such as cardiovascular diseases, diabetes, and respiratory problems, among other comorbidities."
            }

            result > 30f && result <= 39.9f -> {
                "Obesity poses various health risks. In addition to impacting quality of life, being overweight is associated with several serious conditions, such as cardiovascular diseases, diabetes, respiratory problems, and psychological changes (depression, anxiety, low self-esteem, etc)."
            }

            else -> {
                "Severe obesity poses various health risks. In addition to impacting quality of life, being overweight is associated with several serious conditions, such as cardiovascular diseases, diabetes, respiratory problems, and psychological changes (depression, anxiety, low self-esteem, etc). Furthermore, severe obesity carries a high surgical risk."
            }
        }

        tvDescription.text = description
    }
}