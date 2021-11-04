package com.example.sundoboo

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

abstract class NavigationDelegator(
    private val displayView: FragmentContainerView,
    private val navigation: BottomNavigationView,
    private val fragmentManager: FragmentManager,
    private val context: Context,
) {

    private val onItemSelectedListener = NavigationBarView.OnItemSelectedListener {
        replace(mapFragment(it.itemId))
        true
    }

    init {
        navigation.setOnItemSelectedListener(onItemSelectedListener)
    }

    private fun replace(fragment: Fragment) {
        fragmentManager.beginTransaction().replace(displayView.id, fragment).commitAllowingStateLoss()
    }

    abstract fun mapFragment(id: Int) : Fragment

}