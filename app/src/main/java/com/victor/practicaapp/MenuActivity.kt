package com.victor.practicaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.widget.AppCompatButton
import com.victor.practicaapp.convertidor.ConvertidorActivity
import com.victor.practicaapp.firstapp.FirstAppActivity
import com.victor.practicaapp.imccalculator.ImcActivity
import com.victor.practicaapp.tipApp.TipActivity
import com.victor.practicaapp.todoApp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnSaludo = findViewById<Button>(R.id.btnSaludo)
        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        val btnTODO = findViewById<Button>(R.id.btnTODO)
        val btnPropinas = findViewById<Button>(R.id.btnPropinas)
        val btnConvertidor = findViewById<Button>(R.id.btnConvertidor)

        btnSaludo.setOnClickListener { navigateToSaludoApp() }
        btnIMCApp.setOnClickListener { navigateToIMCApp() }
        btnTODO.setOnClickListener { navigteTodoApp() }
        btnPropinas.setOnClickListener { navigateToTipApp() }
        btnConvertidor.setOnClickListener { navigateToConvertidor() }
    }


    private fun navigateToSaludoApp() {
        val intent = Intent(this, FirstAppActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcActivity::class.java)
        startActivity(intent)
    }

    private fun navigteTodoApp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTipApp() {
        val intent = Intent(this, TipActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToConvertidor() {
        val intent = Intent(this, ConvertidorActivity::class.java)
        startActivity(intent)
    }


}