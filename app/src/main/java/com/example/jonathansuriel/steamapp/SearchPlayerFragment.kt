package com.example.jonathansuriel.steamapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

class SearchPlayerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view: View = inflater.inflate(R.layout.fragment_searchplayer, container, false)
        val name: TextView = view.findViewById(R.id.editName)
        val button: Button = view.findViewById(R.id.button)


        button.setOnClickListener {
            val newGamefragment = GameListFragment()
            val fragmentTransaction = activity!!.supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, newGamefragment)
            fragmentTransaction.addToBackStack(null)
            fragmentTransaction.commit()
        }
        return view
    }

    companion object {
        fun newInstance(): SearchPlayerFragment = SearchPlayerFragment()
    }


}