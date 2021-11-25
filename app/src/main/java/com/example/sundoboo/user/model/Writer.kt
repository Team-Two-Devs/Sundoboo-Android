package com.example.sundoboo.user.model

data class Writer(
    val user: User
) {
    fun getId() = user.id
    fun getName() = user.name
}