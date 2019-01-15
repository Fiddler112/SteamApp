package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.LiveData
import android.app.Application
import android.support.annotation.WorkerThread

class SteamRepository (private val SteamDao: SteamDAO) {

    var SteamItems: LiveData<List<Steam>> = SteamDao.getList()

    @WorkerThread
    fun addSteam(steam: Steam) {
        SteamDao.addItem(steam)
    }
    @WorkerThread
    fun getSteam() = SteamDao.getList()
}