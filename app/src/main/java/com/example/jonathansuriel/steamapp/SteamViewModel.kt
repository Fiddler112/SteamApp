package com.example.jonathansuriel.steamapp

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.*
import kotlinx.coroutines.Job
import okhttp3.Dispatcher
import kotlin.coroutines.CoroutineContext

class SteamViewModel(application: Application) : AndroidViewModel(application) {

    private var parentJob = Job()
    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default
    private val scope = CoroutineScope(coroutineContext)

    private val steamRepository: SteamRepository

    var steamitems: LiveData<List<Steam>>

    init {
        val steamDao = SteamDatabase.getDatabase(application, scope).steamDao()
        steamRepository = SteamRepository(steamDao)
        steamitems = steamRepository.SteamItems
    }

        fun insert(steam: Steam) = scope.launch(Dispatchers.IO) {
            steamRepository.addSteam(steam)
        }
    fun delete(game: Steam) = scope.launch(Dispatchers.IO) {
        steamRepository.delete(game)
    }

    override fun onCleared() {
        super.onCleared()
        parentJob.cancel()
    }
    }
