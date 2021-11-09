package com.example.sundoboo.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sundoboo.home.model.Category

class HomeViewModel : ViewModel() {

    //tabLayout에 표시될 목록
    private val _categories = MutableLiveData<List<Category>>()
    val categories : LiveData<List<Category>>
        get() = _categories

    init {
        //Sample Data
        _categories.value = listOf(
            "전체", "음식", "인간 관계", "놀거리", "연애/결혼", "직장 생활", "진로", "주식"
        ).map {
            Category(it)
        }
    }

}