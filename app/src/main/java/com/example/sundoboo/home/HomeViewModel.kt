package com.example.sundoboo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.home.model.Category

class HomeViewModel : ViewModel() {

    //tabLayout에 표시될 목록
    private val _tabItems = MutableLiveData<List<Category>>()
    val tabItems : LiveData<List<Category>>
        get() = _tabItems

}