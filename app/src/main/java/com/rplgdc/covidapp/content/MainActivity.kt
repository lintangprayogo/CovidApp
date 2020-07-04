package com.rplgdc.covidapp.content


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.rplgdc.covidapp.R
import com.rplgdc.covidapp.base.data.model.Country
import com.rplgdc.covidapp.base.data.model.Global
import com.rplgdc.covidapp.base.ui.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : BaseActivity() {
    private lateinit var sumaryViewModel: SumaryViewModel
    private lateinit var adapter: CountryAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        sumaryViewModel = obtainViewModel<SumaryViewModel>()
        adapter = CountryAdapter()
  getSummary()
         retry.setOnClickListener {
             getSummary()
         }
    }

    private  fun getSummary(){
        setupEventView(retry,false)
        setupEventView(progress_bar,true)
        sumaryViewModel.getSumary().observe(this, Observer {
            if (it != null) {
                setGlobal(it.global)
                timestamp.text = setDate(it.date)
                setCountry(it.countries)
                setupEventView(progress_bar, false)
                setupEventView(retry,false)
                setupEventView(content, true)
            }else {
                 setupEventView(progress_bar,false)
                  setupEventView(retry,true)
            }
        }
        )
    }

    private fun setCountry(list: List<Country>) {
        val indonesia = list.find { it.country.equals("Indonesia") }

        if (indonesia != null) {
            val nf = NumberFormat.getInstance(Locale.ENGLISH)
            val confirmed = indonesia.totalConfirmed
            val cured = indonesia.totalRecovered
            val death = indonesia.totalDeaths
            death_your.text = nf.format(death)
            cured_your.text = nf.format(cured)
            confirm_your.text = nf.format(confirmed)
            val imgUrl = "https://www.countryflags.io/${indonesia.countryCode}/shiny/64.png"
            Glide.with(flag).load(imgUrl).into(flag)
        }

        val order = list.sortedByDescending { it.totalConfirmed }
        adapter.addData(order.subList(0, 9))
        adapter.setLayout(R.layout.location_layout, this)
        top_rv.adapter = adapter
        top_rv.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

    }


    private fun setGlobal(global: Global) {
        val nf = NumberFormat.getInstance(Locale.ENGLISH)
        val confirmed = global.totalConfirmed
        val cured = global.totalRecovered
        val death = global.totalDeaths
        confirm_count_global.text = nf.format(confirmed)
        death_count_global.text = nf.format(death)
        cured_count_global.text = nf.format(cured)
    }


    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    @SuppressLint("SimpleDateFormat")
    private fun setDate(dateInput: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
            val outputFormat = SimpleDateFormat("MMM dd yyyy HH:mm:ss")
            val date: Date = inputFormat.parse(dateInput)
            val formattedDate: String = outputFormat.format(date)
            formattedDate
        } catch (e: Exception) {
            "-"
        }
    }
}
