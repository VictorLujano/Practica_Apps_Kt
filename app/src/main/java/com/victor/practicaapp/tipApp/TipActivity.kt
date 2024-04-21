package com.victor.practicaapp.tipApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.slider.RangeSlider
import com.victor.practicaapp.R
import com.victor.practicaapp.imccalculator.ImcActivity
import java.text.DecimalFormat

class TipActivity : AppCompatActivity() {

    private var personasActuales = 1
    private var total:Double = 1.0

    private lateinit var etMontoTotal: EditText
    private lateinit var tvPersonas: TextView
    private lateinit var rsMonos: RangeSlider
    private lateinit var btnCalcularTip: Button

    companion object {
        const val TIP_TOTAL = "TIP_TOTAL"
        const val TIP_TIP10 = "TIP_TIP10"
        const val TIP_TIP5 = "TIP_TIP5"
        const val TIP_XPERSONA10 = "TIP_XPERSONA10"
        const val TIP_XPERSONA5 = "TIP_XPERSONA5"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tip)
        initComponents()
        initListeners()
    }

    private fun initComponents() {

        etMontoTotal = findViewById(R.id.etMontoTotal)
        tvPersonas = findViewById(R.id.tvPersonas)
        rsMonos = findViewById(R.id.rsMonos)
        btnCalcularTip = findViewById(R.id.btnCalcularTip)

    }


    private fun initListeners() {
        rsMonos.addOnChangeListener { _, value, _ ->
            personasActuales = value.toInt()
            tvPersonas.text = "$personasActuales"
        }
        btnCalcularTip.setOnClickListener {
            if (etMontoTotal.text.toString().isNotEmpty()){
                calcularPropina()
            } else{
                Toast.makeText(this, "Debes agregar un monto", Toast.LENGTH_SHORT).show()
            }
        }
    }


    private fun calcularPropina() {
        val entrada = etMontoTotal.text.toString()
        total = entrada.toDoubleOrNull() ?:0.00
        var tip10 = (total/100)*10
        var tip5 = (total/100)*5
        var xpersona10 = (total/personasActuales)+(tip10/personasActuales)
        var xpersona5 = (total/personasActuales)+(tip5/personasActuales)

        val df = DecimalFormat("#.##")
        xpersona10 = df.format(xpersona10).toDouble()
        xpersona5 = df.format(xpersona5).toDouble()
        tip10 = df.format(tip10).toDouble()
        tip5 = df.format(tip5).toDouble()

        val intent = Intent(this, ResultTipActivity::class.java)
        intent.putExtra(TIP_TOTAL, total)
        intent.putExtra(TIP_TIP10, tip10)
        intent.putExtra(TIP_TIP5, tip5)
        intent.putExtra(TIP_XPERSONA10, xpersona10)
        intent.putExtra(TIP_XPERSONA5, xpersona5)
        startActivity(intent)
    }



}