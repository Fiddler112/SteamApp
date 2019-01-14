package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.LiveData
import android.app.Application
import android.support.annotation.WorkerThread

class SteamRepository private constructor(private val SteamDao: SteamDAO) {

    lateinit var SteamItems: LiveData<List<Steam>>

    @WorkerThread
    fun addSteam(steam: Steam) {
        SteamDao.addItem(steam)
    }
    @WorkerThread
    fun getSteam() = SteamDao.getList()
}