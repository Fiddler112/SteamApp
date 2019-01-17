package com.example.jonathansuriel.steamapp
import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
@Entity(tableName = "steam")

data class Steam(@PrimaryKey(autoGenerate = false)
            val name: String,
            val playtime: String
)
