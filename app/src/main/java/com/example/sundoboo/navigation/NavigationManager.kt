package com.example.sundoboo.navigation

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView

abstract class NavigationManager(
    private val navigationViewController: NavigationViewController,
    private val navigationFragments: NavigationFragments,
    private val context: Context,
) {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        navigationViewController.replace(mapFragment(it.itemId))
        true
    }

    init {
        navigationViewController.setItemSelectedListener(onItemSelectedListener)
    }

    private fun mapFragment(id: Int): Fragment {
        return navigationFragments.getFragmentMatchesMenuId(id)
    }


    //id에 맞는 fragment로 시작한다.
    fun startWith(id: Int) {
        navigationViewController.replace(mapFragment(id))
    }

}
