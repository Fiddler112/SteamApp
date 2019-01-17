package com.example.jonathansuriel.steamapp

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import java.lang.Exception

class GameListFragment : Fragment() {

    private lateinit var model: SteamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

   //     model = activity?.run {
  //          ViewModelProviders.of(this).get(SteamViewModel::class.java)
     //   } ?: throw Exception("Invalid activity")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragments_gamelist, container, false)
        val recView = view.findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = GameListAdapter()
        recView.adapter = adapter
        recView.layoutManager = LinearLayoutManager(context)
        model = ViewModelProviders.of(this).get(SteamViewModel::class.java)
        model.steamitems.observe(this, Observer { steam ->
            steam?.let {adapter.setGames(it)}
        })

        val fab: FloatingActionButton = view.findViewById(R.id.add)
        fab.setOnClickListener {
            val newGamefragment = NewGameFragment()
            val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, newGamefragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            //Called when a user swipes left or right on a ViewHolder
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, swipeDir: Int) {

                //Get the index corresponding to the selected position
                val position = viewHolder.adapterPosition
                model.delete(model.steamitems.value!![position!!])
                adapter.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(recView)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    companion object {
        fun newInstance(): GameListFragment = GameListFragment()
    }
}