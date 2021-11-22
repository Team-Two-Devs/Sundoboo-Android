package com.example.sundoboo.feed.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sundoboo.feed.model.FeedItem
import com.example.sundoboo.utils.Event

interface FeedItemNavigator {
    val navigateToDetailEvent: LiveData<Event<FeedItem>>

    fun navigateToDetail(feed: FeedItem)
}

class HomeFeedItemNavigator : FeedItemNavigator {
    private val _navigateToDetailEvent = MutableLiveData<Event<FeedItem>>()
    override val navigateToDetailEvent: LiveData<Event<FeedItem>>
        get() = _navigateToDetailEvent

    override fun navigateToDetail(feed: FeedItem) {
        _navigateToDetailEvent.value = Event(feed)
    }

}