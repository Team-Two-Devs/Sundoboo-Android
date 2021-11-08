package com.example.sundoboo.feed

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.feed.model.TabItem

class FeedViewModel : ViewModel() {

    //tabLayout에 표시될 목록
    private val _tabItems = MutableLiveData<List<TabItem>>()
    val tabItems : LiveData<List<TabItem>>
        get() = _tabItems

}