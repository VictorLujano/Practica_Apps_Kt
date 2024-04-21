package com.victor.practicaapp.firstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.victor.practicaapp.R

class FirstAppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first_app)
        val btnStart = findViewById<AppCompatButton>(R.id.btnStart)
        val etName = findViewById<AppCompatEditText>(R.id.etName)
        // Al arrancar la pantalla

        btnStart.setOnClickListener {
            val nombre = etName.text.toString()


            if(nombre.isNotEmpty()) {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra("Extra_Name", nombre)
                startActivity(intent)
            }
            else
                Toast.makeText(this, "Ingres tu nombre", Toast.LENGTH_SHORT).show()
        }


    }
}