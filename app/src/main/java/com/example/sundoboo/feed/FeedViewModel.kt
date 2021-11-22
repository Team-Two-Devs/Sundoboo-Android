package com.example.sundoboo.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.model.FeedItem
import com.example.sundoboo.vote.Vote
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor() : ViewModel() {

    private val _feedItems = MutableLiveData<List<FeedItem>>()
    val feedItems: LiveData<List<FeedItem>>
        get() = _feedItems

    init {
        _feedItems.value = (1..1000).map {
            when {
                it % 3 == 0 -> {
                    FeedItem(
                        title = "TEST$it",
                        description = "TEST DESCRIPTION",
                        votes = listOf(
                            Vote(checked = true, description = "TEST VOTE", showCount = true, countOfVoter = it),
                            Vote(checked = false, description = "TEST VOTE", showCount = true, countOfVoter = it / 2)
                        )
                    )
                }
                it % 5 == 0 -> {
                    FeedItem(
                        title = "TEST$it",
                        description = "TEST DESCRIPTION",
                        votes = listOf(
                            Vote(checked = false, description = "TEST VOTE", showCount = true, countOfVoter = it),
                            Vote(checked = true, description = "TEST VOTE", showCount = true, countOfVoter = it / 4),
                            Vote(checked = false, description = "TEST VOTE", showCount = true, countOfVoter = it / 4)
                        )
                    )
                }
                else -> {
                    FeedItem(
                        title = "TEST$it",
                        description = "TEST DESCRIPTION",
                        votes = listOf(
                            Vote(checked = false, description = "TEST VOTE"),
                            Vote(checked = false, description = "TEST VOTE")
                        )
                    )
                }
            }
        }
    }

}