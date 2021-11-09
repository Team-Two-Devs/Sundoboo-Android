package com.example.sundoboo.navigation

import android.content.Context
import com.google.android.material.navigation.NavigationBarView

abstract class NavigationManager(
    private val navigationViewController: NavigationViewController,
    private val navigationFragments: NavigationFragments,
    private val context: Context,
) {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        replace(it.itemId)
        true
    }

    init {
        navigationViewController.setItemSelectedListener(onItemSelectedListener)
    }

    private fun replace(id: Int) {
        val fragmentToReplace = navigationFragments.getFragmentMatchesMenuId(id)

        if (!navigationViewController.alreadyExists(fragmentToReplace)) {
            navigationViewController.replace(fragmentToReplace)
        }
    }

    //첫번째 fragment로 시작한다.
    fun start(id: Int) {
        replace(id)
    }

}
