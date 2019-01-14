package com.example.jonathansuriel.steamapp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

class SteamViewModel(private val steamRepository: SteamRepository) : ViewModel() {

    lateinit var steamitems: LiveData<List<Steam>>
    fun getSteamList() = steamRepository.getSteam()

    fun addSteamItem(steam: Steam) = steamRepository.addSteam(steam)
}