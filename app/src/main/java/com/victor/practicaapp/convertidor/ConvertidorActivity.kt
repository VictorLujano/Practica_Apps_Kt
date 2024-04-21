package com.victor.practicaapp.convertidor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.victor.practicaapp.R

class ConvertidorActivity : AppCompatActivity() {

    private lateinit var etCantidadPeso: EditText
    private lateinit var tvUnidad1: TextView
    private lateinit var tvUnidad2: TextView
    private lateinit var btnSwitch: ImageView
    private lateinit var tvResultadoPeso: TextView
    private lateinit var btnCalcularMasa: Button

    private var unidad1 = "KG"
    private var unidad2 = "LB"
    private var masa = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_convertidor)
        initComponents()
        initListeners()
    }

    private fun initComponents() {
        etCantidadPeso = findViewById(R.id.etCantidadPeso)
        tvUnidad1 = findViewById(R.id.tvUnidad1)
        tvUnidad2 = findViewById(R.id.tvUnidad2)
        btnSwitch = findViewById(R.id.btnSwitch)
        tvResultadoPeso = findViewById(R.id.tvResultadoPeso)
        btnCalcularMasa = findViewById(R.id.btnCalcularMasa)
    }

    private fun initListeners() {
        btnSwitch.setOnClickListener {
            if (tvUnidad1.text == unidad1){
                tvUnidad1.text = unidad2
                tvUnidad2.text = unidad1
                unidad1 = tvUnidad1.text.toString()
                unidad2 = tvUnidad2.text.toString()
            } else {
                tvUnidad1.text = unidad1
                tvUnidad2.text = unidad2
                unidad1 = tvUnidad1.text.toString()
                unidad2 = tvUnidad2.text.toString()
            }
        }
        btnCalcularMasa.setOnClickListener {
            val peso = etCantidadPeso.text.toString()
            masa = peso.toDoubleOrNull() ?:0.0

            if (peso.isNotEmpty() && masa!=0.0){
                if (unidad1=="KG"){
                    val kgtolb = (masa*2.20462)
                    tvResultadoPeso.text = kgtolb.toString()
                } else {
                    val lbtokg = (masa*0.453592)
                    tvResultadoPeso.text = lbtokg.toString()
                }
            } else{
                Toast.makeText(this, "Ingrese un numero", Toast.LENGTH_SHORT).show()
            }
        }
    }

}