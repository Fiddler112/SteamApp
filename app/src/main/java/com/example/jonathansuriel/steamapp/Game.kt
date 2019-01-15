package com.example.jonathansuriel.steamapp

data class Game(
    val appid: Int,
    val has_community_visible_stats: Boolean,
    val img_icon_url: String,
    val img_logo_url: String,
    val name: String,
    val playtime_2weeks: Int,
    val playtime_forever: Int
)