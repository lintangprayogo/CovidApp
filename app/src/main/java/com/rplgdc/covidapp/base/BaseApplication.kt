package com.rplgdc.covidapp.base

import android.app.Application
import android.content.Context

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: BaseApplication
        fun getContext(): Context = instance.applicationContext
    }

}