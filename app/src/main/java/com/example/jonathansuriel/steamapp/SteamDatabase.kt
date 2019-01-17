package com.example.jonathansuriel.steamapp

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch

@Database(entities = [Steam::class], version = 2)
abstract class SteamDatabase : RoomDatabase() {

    abstract fun steamDao(): SteamDAO

    companion object {
        @Volatile
        private var INSTANCE: SteamDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope) : SteamDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SteamDatabase::class.java,
                    "Steam_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(SteamDatabaseCallback(scope))
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
        private class SteamDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {
            /**
             * Override the onOpen method to populate the database.
             * For this sample, we clear the database every time it is created or opened.
             */
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {

                    }
                }
            }
        }
    }

}