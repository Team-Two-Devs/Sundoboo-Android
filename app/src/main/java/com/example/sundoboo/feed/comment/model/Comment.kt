package com.example.sundoboo.feed.comment.model

import com.example.sundoboo.user.model.Writer

data class Comment(
    val id: String,
    val description: String,
    val date: String,
    val writer: Writer,
) {
    val writerName : String
        get() = writer.name
}