package com.rplgdc.covidapp.content

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.rplgdc.covidapp.base.data.model.Sumary
import com.rplgdc.covidapp.base.data.source.Repo

class SumaryViewModel(val repo: Repo) : ViewModel() {
    fun getSumary(): LiveData<Sumary> {
        return repo.getSumary()
    }
}