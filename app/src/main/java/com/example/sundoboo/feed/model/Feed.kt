package com.example.sundoboo.feed.model

import com.example.sundoboo.vote.Vote

data class Feed(
    val id: String,
    val title: String,
    val description: String,
    val countOfVoter: Int,
    val votes: List<Vote> = listOf(),
    //TODO 2021.11.12 작성자를 표시하는 writer: Writer 클래스 추가하기
)