package com.example.sundoboo.feed.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.comment.model.Comment
import com.example.sundoboo.user.model.User
import com.example.sundoboo.user.model.Writer
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CommentsViewModel @Inject constructor(

) : ViewModel() {

    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>>
        get() = _comments

    init {
        _comments.value = listOf(
            Comment("", "나도 배고파", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "그냥 굶어", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "짜장면은 어때?", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "나는 짬뽕이 좋아", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "치킨 먹자", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "나는 피자", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "피자가 있으면 큐자도 있나? ㅋㅋㅋ", "2021.11.25", Writer(User.Anonymous)),
            Comment("", "깔깔 재미지다", "2021.11.25", Writer(User.Anonymous)),
        )
    }

}