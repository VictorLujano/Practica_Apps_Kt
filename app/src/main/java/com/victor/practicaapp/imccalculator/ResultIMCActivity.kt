package com.victor.practicaapp.imccalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.victor.practicaapp.R
import com.victor.practicaapp.imccalculator.ImcActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResultado:TextView
    private lateinit var tvIMC:TextView
    private lateinit var tvDescripcion:TextView
    private lateinit var btnReCalculate:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        val resultado = intent.extras?.getDouble(IMC_KEY) ?: -1.0
        initComponent()
        initUI(resultado)
        initListeners()


    }


    private fun initComponent() {
        tvResultado = findViewById(R.id.tvResultado)
        tvIMC = findViewById(R.id.tvIMC)
        tvDescripcion = findViewById(R.id.tvDescripcion)
        btnReCalculate = findViewById(R.id.btnReCalculate)

    }

    private fun initUI(resultado: Double) {
        tvIMC.text = resultado.toString()
        when(resultado) {
            in 0.00..18.50 -> { // Bajo peso
                tvResultado.text = getString(R.string.titulo_bajo_peso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_bajo))
                tvDescripcion.text = getString(R.string.descripcion_bajo_peso)
            }
            in 18.51..24.99 -> { // peso normal
                tvResultado.text = getString(R.string.titulo_normal)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_normal))

                tvDescripcion.text = getString(R.string.descripcion_normal)
            }
            in 25.00..29.99 -> { //sobre peso
                tvResultado.text = getString(R.string.titulo_sobrepeso)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.peso_sobrepeso))
                tvDescripcion.text = getString(R.string.descripcion_sobrepeso)
            }
            in 30.00..99.00 -> { //obesidad
                tvResultado.text = getString(R.string.titulo_obesidad)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescripcion.text = getString(R.string.descripcion_obesidad)
            }
            else  -> { // Error
                tvResultado.text = getString(R.string.error)
                tvResultado.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvIMC.text = getString(R.string.error)
                tvIMC.setTextColor(ContextCompat.getColor(this, R.color.obesidad))
                tvDescripcion.text = getString(R.string.error)
                tvDescripcion.setTextColor(ContextCompat.getColor(this, R.color.obesidad))

            }
        }
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener {
            onBackPressed()
        }
    }
}