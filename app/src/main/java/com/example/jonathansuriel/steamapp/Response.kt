package com.example.jonathansuriel.steamapp

data class Response(
    val game_count: Int,
    val games: List<Game>
)