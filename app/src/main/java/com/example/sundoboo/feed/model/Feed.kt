package com.example.sundoboo.feed.model

import com.example.sundoboo.feed.comment.model.Comment
import com.example.sundoboo.user.model.Writer
import com.example.sundoboo.vote.Vote

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val votes: List<Vote> = listOf(),
    val writer: Writer,
    val countOfComment: Int,
) {

    val countOfVoter: Int
        get() = votes.sumOf { it.countOfVoter }

}
