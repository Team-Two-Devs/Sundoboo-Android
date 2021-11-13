package com.example.sundoboo.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.search.model.SearchHistory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchFeedsViewModel @Inject constructor() : ViewModel() {

    //추후 Store의 형태로 작업하여 하나로 합칠 예정
    private val _searchHistories = MutableLiveData<List<SearchHistory>>()
    val searchHistories: LiveData<List<SearchHistory>>
        get() = _searchHistories

    init {
        //fake data
        _searchHistories.value = (1..100).map {
            SearchHistory(it.toString())
        }
    }

}