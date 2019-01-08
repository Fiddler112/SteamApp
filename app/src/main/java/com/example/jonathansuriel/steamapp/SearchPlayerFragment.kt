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
        return view
    }


}