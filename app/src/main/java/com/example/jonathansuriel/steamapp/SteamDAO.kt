package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import android.arch.persistence.room.OnConflictStrategy.REPLACE

@Dao

interface SteamDAO {
    @Query("SELECT * FROM steam")
    fun getList(): LiveData<List<Steam>>

    @Update
    fun update(steam: Steam)

    @Insert (onConflict = REPLACE)
    fun addItem(steam: Steam)

    @Query("DELETE FROM steam")
    fun deleteAll()

    @Delete
    fun delete(bucket: Steam)
}