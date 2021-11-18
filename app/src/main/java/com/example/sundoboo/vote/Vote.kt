package com.example.sundoboo.vote

data class Vote(
    val id: String = "",
    val checked: Boolean = false,
    val description: String = "",
    val countOfVoter: Int = 0,
    val showCount: Boolean = false,
)