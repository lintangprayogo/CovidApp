package com.rplgdc.covidapp.base.data.source.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rplgdc.covidapp.base.data.source.Injection
import com.rplgdc.covidapp.base.data.source.Repo
import com.rplgdc.covidapp.content.SumaryViewModel

class ViewModelFactory(val repo: Repo) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        @JvmStatic
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE =
                        ViewModelFactory(Injection.provideRepo())

                }
            }
            return INSTANCE!!
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SumaryViewModel::class.java)) {
            return SumaryViewModel(repo) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}