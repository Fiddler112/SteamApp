package com.example.jonathansuriel.steamapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class GameListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragments_gamelist, container, false)
        val recView = view.findViewById<RecyclerView>(R.id.recyclerView)
        return view
    }

    companion object {
        fun newInstance(): GameListFragment = GameListFragment()
    }
}