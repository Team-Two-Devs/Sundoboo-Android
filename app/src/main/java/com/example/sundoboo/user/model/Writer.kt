package com.example.sundoboo.user.model

data class Writer(
    val user: User
) {
    //Todo (2021.11.25) 프로퍼티로 변경할까 고민 중...
    fun getId() = user.id
    fun getName() = user.name
}