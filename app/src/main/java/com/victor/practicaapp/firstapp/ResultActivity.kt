package com.victor.practicaapp.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.victor.practicaapp.R

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val tvResult = findViewById<TextView>(R.id.tvTexto)
        val name:String = intent.extras?.getString("Extra_Name").orEmpty()

        tvResult.text = "Hola $name"

    }
}