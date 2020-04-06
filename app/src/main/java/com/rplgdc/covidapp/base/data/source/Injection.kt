package com.rplgdc.covidapp.base.data.source

import com.rplgdc.covidapp.base.data.source.remote.RemoteRepo

object Injection {
    fun provideRepo(): Repo {
        val remoteRepo = RemoteRepo.getInstance()
        return Repo(remoteRepo)
    }

}