package com.example.sundoboo.user.model

data class User(
    val id: String,
    val name: String,
) {

    companion object Other {
        val Anonymous: User = User("anonymous", "미공개")
    }

}