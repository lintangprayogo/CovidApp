package com.rplgdc.covidapp.base.data.source

interface LoadCallback<T> {
    fun onDataReceived(data: T?)
    fun onDataNotAvaible(msg: String)
}