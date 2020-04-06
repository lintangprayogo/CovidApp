package com.rplgdc.covidapp.base.data.source

import androidx.lifecycle.LiveData
import com.rplgdc.covidapp.base.data.model.Sumary

interface DataSource {
    fun getSumary(): LiveData<Sumary>
}