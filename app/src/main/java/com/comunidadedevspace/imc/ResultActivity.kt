package com.comunidadedevspace.imc

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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

        val imgBack = findViewById<ImageView>(R.id.ic_back)

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
                "Being underweight can pose greater health risks than obesity, irrespective of other risk factors. Research indicates that the mortality risk is 80% higher in underweight individuals compared to those with a healthy weight. Furthermore, consequences of being underweight include malnutrition, weakened bones, and a compromised immune system."
            }

            result > 18.5f && result <= 24.9f -> {
                "Maintaining an ideal weight offers numerous health benefits and contributes to overall well-being. Furthermore, it plays a crucial role in disease prevention and promotes a healthier lifestyle. To achieve and sustain this weight, prioritize a nutritious diet and engage in regular exercise."
            }

            result > 25f && result <= 29.9f -> {
                "Excess weight, as determined by the Body Mass Index (BMI), carries substantial health risks. Beyond its impact on quality of life, being overweight is linked to several serious conditions, including cardiovascular diseases, diabetes, and respiratory issues, among other comorbidities."
            }

            result > 30f && result <= 39.9f -> {
                "Obesity presents a range of health risks. Beyond its impact on quality of life, being overweight is linked to several serious conditions, including cardiovascular diseases, diabetes, respiratory issues, and psychological changes (such as depression, anxiety, and low self-esteem)."
            }

            else -> {
                "Severe obesity is associated with a spectrum of health risks. Beyond its impact on quality of life, being overweight is linked to several serious conditions, including cardiovascular diseases, diabetes, respiratory issues, and psychological changes (such as depression, anxiety, and low self-esteem). Furthermore, severe obesity significantly increases the surgical risk."
            }
        }

        tvDescription.text = description

        imgBack.setOnClickListener {
         val back = Intent(this, MainActivity::class.java)
            startActivity(back)
        }
    }
}