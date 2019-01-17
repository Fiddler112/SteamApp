package com.example.jonathansuriel.steamapp

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class GameListAdapter internal constructor(

) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {


    private var games = emptyList<Steam>()

    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameItemViewTitle: TextView = itemView.findViewById(R.id.mTitlee)
        val gameItemViewHours: TextView = itemView.findViewById(R.id.mHours)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): GameViewHolder {
        val view = LayoutInflater.from(p0.context)
        val itemView = view.inflate(R.layout.steam_item, p0, false)
        return GameViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: GameViewHolder, p1: Int) {
        val current = games[p1]
        p0.gameItemViewTitle.text = current.name
        p0.gameItemViewHours.text = current.playtime.toString()
    }

    internal fun setGames(games: List<Steam>) {
        this.games = games
        notifyDataSetChanged()
    }

    override fun getItemCount() = games.size


}
