package com.example.p5_chart

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.p5_chart.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var binding  : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var myChart: PieChart = binding.pieChart1
        //ArrayList<PieEntry> entries = new ArrayList<>();
        var dataList: ArrayList<PieEntry> = arrayListOf()
       for (i in 0 until 5){
           dataList.add(PieEntry((Math.random() * 5 + 5).toFloat()))
       }

        //PieDataSet dataSet = new PieDataSet(entries, "Election Results");
        var dataSet = PieDataSet(dataList,"Resultados")
        var colors: ArrayList<Int> = ArrayList()
        for (c in ColorTemplate.PASTEL_COLORS){
            colors.add(c)
        }
        dataSet.colors = colors


        var data = PieData(dataSet)
        data.setValueFormatter(PercentFormatter())
        data.setValueTextSize(20f)
        data.setValueTextColor(Color.BLACK)
        myChart.setData(data)

        binding.btnActualizar.setOnClickListener {
            dataList.clear()
            var texto = binding.etValores.text
            val bigarray = texto.split(",")
            for(number in bigarray){
                dataList.add(PieEntry(number.toFloat()))
            }
            dataSet = PieDataSet(dataList,"Resultados")
            dataSet.colors = colors
            data = PieData(dataSet)
            data.setValueFormatter(PercentFormatter())
            data.setValueTextSize(20f)
            data.setValueTextColor(Color.BLACK)
            myChart.setData(data)
            setContentView(view)

        }
    }
}