package com.example.sundoboo.user.model

data class Writer(
    val user: User
) {
    val id : String get() = user.id
    val name: String get() = user.name
}