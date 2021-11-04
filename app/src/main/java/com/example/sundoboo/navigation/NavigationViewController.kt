package com.example.sundoboo.navigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class NavigationViewController(
    private val displayView: FragmentContainerView,
    private val navigation: BottomNavigationView,
    private val fragmentManager: FragmentManager,
) {

    fun setItemSelectedListener(listener: NavigationBarView.OnItemSelectedListener) {
        navigation.setOnItemSelectedListener(listener)
    }

    fun replace(fragment: Fragment) {
        fragmentManager.beginTransaction().replace(displayView.id, fragment).commitAllowingStateLoss()
    }

}