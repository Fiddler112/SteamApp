package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NewGameFragment : Fragment(){

    private var model: SteamViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_newgame, container, false)

        val title: TextView = view.findViewById(R.id.mTitlee)
        val playtime: TextView = view.findViewById(R.id.mPlaytime)
        model = ViewModelProviders.of(this).get(SteamViewModel::class.java)
        val fab = view.findViewById<FloatingActionButton>(R.id.floatingActionButton)
        fab.setOnClickListener {
            val title = title.text.toString()
            val playtime = playtime.text.toString()

            val game = Steam(title, playtime)
            model!!.insert(game)
            fragmentManager!!.popBackStack()
        }
        return view
    }
}