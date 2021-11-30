package com.example.sundoboo.feed.model

import com.example.sundoboo.user.model.Writer
import com.example.sundoboo.vote.Vote

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val countOfVoter: Int,
    val votes: List<Vote> = listOf(),
    val writer: Writer,
)