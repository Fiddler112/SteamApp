package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var model: SteamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.model = ViewModelProviders.of(this).get(SteamViewModel::class.java)
        openFragment(SearchPlayerFragment.newInstance())

    }

     fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
        supportFragmentManager.executePendingTransactions()
    }
}
