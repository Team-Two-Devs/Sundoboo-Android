package com.example.sundoboo.feed.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.list.FeedItemNavigator
import com.example.sundoboo.feed.model.Feed
import com.example.sundoboo.vote.Vote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedDetailViewModel @Inject constructor(

) : ViewModel() {

    private val _feed = MutableLiveData<Feed>()
    val feed: LiveData<Feed>
        get() = _feed

    init {
        _feed.value = Feed(
            id = "TEST",
            title = "오늘 점심 뭐 먹지?",
            description = "회사 근처에 김밥천국도 있고 중국집도 있고 국밥집도 있고 먹을 게 많은데 먹을 게 없네 ^^.. 왜 이럴까 아 배고프다 하하하",
            countOfVoter = 105,
            votes = listOf(
                Vote(description = "중국집"),
                Vote(description = "김밥천국"),
                Vote(description = "국밥집"),
                Vote(description = "편의점")
            )
        )
    }

}