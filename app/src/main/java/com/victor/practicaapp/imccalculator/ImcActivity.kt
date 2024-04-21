package com.victor.practicaapp.imccalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import com.victor.practicaapp.R
import java.text.DecimalFormat

class ImcActivity : AppCompatActivity() {

    private var isMaleSelected = true
    private var isFemaleSelected = false
    private var pesoActual = 70
    private var edadActual = 20
    private var alturaActual = 120

    private lateinit var viewMale: CardView
    private lateinit var viewFemale: CardView
    private lateinit var tvHeight: TextView
    private lateinit var rsHeight: RangeSlider
    private lateinit var tvPeso: TextView
    private lateinit var btnMenosPeso: FloatingActionButton
    private lateinit var btnMasPeso: FloatingActionButton
    private lateinit var tvEdad: TextView
    private lateinit var btnMenosEdad: FloatingActionButton
    private lateinit var btnMasEdad: FloatingActionButton
    private lateinit var btnCalcularIMC: Button

    companion object {
        const val IMC_KEY = "IMC_RESULTADO"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc)
        initComponents()
        initListeners()
        initUI()

    }

    private fun initComponents() {
        viewMale = findViewById(R.id.cvMale)
        viewFemale = findViewById(R.id.cvFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight = findViewById(R.id.rsHeight)
        tvPeso = findViewById(R.id.tvPeso)
        btnMenosPeso = findViewById(R.id.btnMenosPeso)
        btnMasPeso = findViewById(R.id.btnMasPeso)
        tvEdad = findViewById(R.id.tvEdad)
        btnMenosEdad = findViewById(R.id.btnMenosEdad)
        btnMasEdad = findViewById(R.id.btnMasEdad)
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC)
    }


    private fun initListeners() {
        viewMale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        viewFemale.setOnClickListener {
            changeGender()
            setGenderColor()
        }
        rsHeight.addOnChangeListener { _, value, _ ->
            alturaActual = value.toInt()
            tvHeight.text = "${value.toInt()} CM"
        }
        btnMenosPeso.setOnClickListener {
            pesoActual -= 1
            obtenerPeso()
        }
        btnMasPeso.setOnClickListener {
            pesoActual += 1
            obtenerPeso()
        }
        btnMenosEdad.setOnClickListener {
            edadActual -= 1
            obtenerEdad()
        }

        btnMasEdad.setOnClickListener {
            edadActual += 1
            obtenerEdad()
        }
        btnCalcularIMC.setOnClickListener {
            val resultado = calcularIMC()
            navigateToResult(resultado)
        }

    }

    private fun navigateToResult(resultado: Double) {
        val intent = Intent(this, ResultIMCActivity::class.java)
        intent.putExtra(IMC_KEY, resultado)
        startActivity(intent)
    }

    private fun calcularIMC():Double {
        val df = DecimalFormat("#.##")
        val imc = pesoActual / (alturaActual.toDouble()/100*alturaActual.toDouble()/100)
        return df.format(imc).toDouble()
    }

    private fun obtenerPeso() {
        tvPeso.text = "${pesoActual} KG"
    }

    private fun obtenerEdad() {
        tvEdad.text = edadActual.toString()
    }


    private fun changeGender() {
        isMaleSelected = !isMaleSelected
        isFemaleSelected = !isFemaleSelected
    }

    private fun setGenderColor() {
        viewMale.setCardBackgroundColor(getBackgroundColor(isMaleSelected))
        viewFemale.setCardBackgroundColor(getBackgroundColor(isFemaleSelected))
    }

    private fun getBackgroundColor(isSelectedComponent: Boolean): Int {
        var colorReference = if (isSelectedComponent) {
            R.color.background_component_selected
        } else {
            R.color.background_component
        }

        return ContextCompat.getColor(this, colorReference)
    }

    private fun initUI() {
        setGenderColor()
        obtenerPeso()
        obtenerEdad()
    }
}