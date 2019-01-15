package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.Exception

class GameListFragment : Fragment() {

    private lateinit var model: SteamViewModel


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragments_gamelist, container, false)
        val recView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = GameListAdapter()
        recView.adapter = adapter
        recView.layoutManager = LinearLayoutManager(context)
        model = ViewModelProviders.of(this).get(SteamViewModel::class.java)
        model.getSteamList().observe(this, Observer { steam ->
            steam?.let {adapter.setGames(it)}
        })



        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

  //  companion object {
  //      fun newInstance(): GameListFragment = GameListFragment()
  //  }
}