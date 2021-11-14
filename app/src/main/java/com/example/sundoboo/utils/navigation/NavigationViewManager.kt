package com.example.sundoboo.utils.navigation

import android.content.Context
import com.example.sundoboo.utils.fragment.FragmentStore
import com.google.android.material.navigation.NavigationBarView

class NavigationViewManager(
    private val navigationViewController: NavigationViewController,
    private val fragmentStore: FragmentStore<Int>,
    private val context: Context,
    private val startId: Int,
) {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        replace(it.itemId)
        true
    }

    init {
        navigationViewController.setItemSelectedListener(onItemSelectedListener)
        replace(startId)
    }

    private fun replace(id: Int) {
        val fragmentToReplace = fragmentStore.findFragmentByKey(id)
        navigationViewController.replace(fragmentToReplace)
    }

}
