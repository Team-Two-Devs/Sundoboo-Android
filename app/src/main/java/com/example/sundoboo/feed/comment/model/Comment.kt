package com.example.sundoboo.feed.comment.model

import com.example.sundoboo.user.model.Writer

data class Comment(
    val id: String,
    val description: String,
    val date: String,
    val writer: Writer,
) {
    //Todo (2021.11.25) 프로퍼티로 변경할까 고민 중...
    fun getWriterName() = writer.getName()
}