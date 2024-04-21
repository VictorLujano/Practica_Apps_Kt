package com.victor.practicaapp.tipApp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.victor.practicaapp.R
import com.victor.practicaapp.imccalculator.ImcActivity

class ResultTipActivity : AppCompatActivity() {

    private lateinit var tvTotal: TextView
    private lateinit var tvTotalpropina10: TextView
    private lateinit var tvTotalpropina5: TextView
    private lateinit var tvxpersona10: TextView
    private lateinit var tvxpersona5: TextView
    private lateinit var tvpropina10: TextView
    private lateinit var tvpropina5: TextView
    private lateinit var btnRegresarTip: Button

    private var total1 = -1.0
    private var propina10 = -1.0
    private var propina5 = -1.0
    private var totalxpersona10 = -1.0
    private var totalxpersona5 = -1.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_tip)
        initComponents()
        unitExtras()
        initUi()
        initListeners()


    }


    private fun initComponents() {
        tvTotal = findViewById(R.id.tvTotal)
        tvTotalpropina10 = findViewById(R.id.tvTotalpropina10)
        tvTotalpropina5 = findViewById(R.id.tvTotalpropina5)
        tvxpersona10 = findViewById(R.id.tvxpersona10)
        tvxpersona5 = findViewById(R.id.tvxpersona5)
        tvpropina10 = findViewById(R.id.tvpropina10)
        tvpropina5 = findViewById(R.id.tvpropina5)
        btnRegresarTip = findViewById(R.id.btnRegresarTip)

    }

    private fun unitExtras() {
        total1 = intent.extras?.getDouble(TipActivity.TIP_TOTAL) ?: -1.0
        propina10 = intent.extras?.getDouble(TipActivity.TIP_TIP10) ?: -1.0
        propina5 = intent.extras?.getDouble(TipActivity.TIP_TIP5) ?: -1.0
        totalxpersona10 = intent.extras?.getDouble(TipActivity.TIP_XPERSONA10) ?: -1.0
        totalxpersona5 = intent.extras?.getDouble(TipActivity.TIP_XPERSONA5) ?: -1.0
    }

    private fun initUi() {
        tvTotal.text = "Total: $${total1}"
        val totalmaspropina10 = (total1 + propina10)
        tvTotalpropina10.text = "$${totalmaspropina10}"
        val totalmaspropina5 = (total1 + propina5)
        tvTotalpropina5.text = "$${totalmaspropina5}"
        tvxpersona10.text = "$${totalxpersona10}"
        tvxpersona5.text = "$${totalxpersona5}"
        tvpropina10.text = "$${propina10}"
        tvpropina5.text = "$${propina5}"
    }

    private fun initListeners() {
        btnRegresarTip.setOnClickListener {
            finish()
        }
    }


}