package com.rplgdc.covidapp.base.data.source.remote

import android.annotation.SuppressLint
import com.rplgdc.covidapp.base.data.model.Sumary
import com.rplgdc.covidapp.base.data.source.LoadCallback
import io.reactivex.schedulers.Schedulers


class RemoteRepo {
    companion object {
        @JvmStatic
        private var INSTANCE: RemoteRepo? = null

        @JvmStatic
        fun getInstance(): RemoteRepo {
            return INSTANCE ?: RemoteRepo().also {
                INSTANCE = it
            }
        }
    }

    @SuppressLint("CheckResult")
    fun getSumary(callback: LoadCallback<Sumary?>) {
        ApiService.getApiService.getSumary().subscribeOn(Schedulers.io())
            .doOnError { callback.onDataNotAvaible(it.localizedMessage ?: "Unknown") }
            .subscribe { callback.onDataReceived(it) }
    }


}