package com.example.sundoboo.utils.navigation

import android.content.Context
import com.example.sundoboo.utils.fragment.FragmentStore
import com.google.android.material.navigation.NavigationBarView

class NavigationViewManager(
    private val navigationViewController: NavigationViewController,
    private val fragmentStore: FragmentStore<Int>,
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
        val fragmentToReplace = fragmentStore.findFragmentByKey(id)

        if (!navigationViewController.alreadyExists(fragmentToReplace)) {
            navigationViewController.replace(fragmentToReplace)
        }
    }

    //첫번째 fragment로 시작한다.
    fun start(id: Int) {
        replace(id)
    }

}
