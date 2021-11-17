package com.example.sundoboo.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.model.Feed
import com.example.sundoboo.vote.Vote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

    private val _feeds = MutableLiveData<List<Feed>>()
    val feed: LiveData<List<Feed>>
        get() = _feeds

    init {
        _feeds.value = (1..1000).map {
            if (it % 3 == 0) {
                Feed(
                    title = "TEST$it",
                    description = "TEST DESCRIPTION",
                    votes = listOf(Vote(true, "TEST VOTE"), Vote(false, "TEST VOTE"))
                )
            } else if (it % 5 == 0) {
                Feed(
                    title = "TEST$it",
                    description = "TEST DESCRIPTION",
                    votes = listOf(Vote(false, "TEST VOTE"), Vote(true, "TEST VOTE"), Vote(false, "TEST VOTE"))
                )
            } else {
                Feed(
                    title = "TEST$it",
                    description = "TEST DESCRIPTION",
                    votes = listOf(Vote(false, "TEST VOTE"), Vote(false, "TEST VOTE"))
                )
            }
        }
    }

}