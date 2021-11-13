package com.example.sundoboo.feed.model

import com.example.sundoboo.vote.Vote

data class Feed(
    val id: String = "",
    val title: String,
    val description: String,
    val votes: List<Vote> = listOf(),
)