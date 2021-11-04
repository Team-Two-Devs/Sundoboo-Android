package com.example.sundoboo.navigation

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView

abstract class NavigationDelegator(
    private val navigationViewController: NavigationViewController,
    protected val navigationFragments: NavigationFragments,
    private val context: Context,
) {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        navigationViewController.replace(mapFragment(it.itemId))
        true
    }

    init {
        navigationViewController.setItemSelectedListener(onItemSelectedListener)
    }

    abstract fun mapFragment(id: Int) : Fragment

}