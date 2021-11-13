package com.example.sundoboo.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.model.Feed

class FeedViewModel : ViewModel() {

    private val _feeds = MutableLiveData<List<Feed>>()
    val feed : LiveData<List<Feed>>
        get() = _feeds

    init {
        _feeds.value = (1..1000).map {
            Feed(title = "TEST$it", description = "TEST DESCRIPTION")
        }
    }

}