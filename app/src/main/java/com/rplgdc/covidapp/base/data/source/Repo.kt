package com.rplgdc.covidapp.base.data.source

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.rplgdc.covidapp.base.data.model.Sumary
import com.rplgdc.covidapp.base.data.source.remote.RemoteRepo

class Repo(private val remoteRepo: RemoteRepo) : DataSource {
    companion object {
        @JvmStatic
        @Volatile
        private var INSTANCE: Repo? = null
        private var TAG = "Repository"

        @JvmStatic
        fun getInstance(remoteRepo: RemoteRepo): Repo {
            return INSTANCE ?: Repo(remoteRepo).also {
                INSTANCE = Repo(remoteRepo)
            }
        }

    }

    override fun getSumary(): LiveData<Sumary> {
        val result: MutableLiveData<Sumary> = MutableLiveData()
        remoteRepo.getSumary(object : LoadCallback<Sumary?> {
            override fun onDataReceived(data: Sumary?) {
                result.postValue(data)
            }

            override fun onDataNotAvaible(msg: String) {
                result.postValue(null)
                Log.d(TAG, msg)
            }

        })
        return result
    }
}