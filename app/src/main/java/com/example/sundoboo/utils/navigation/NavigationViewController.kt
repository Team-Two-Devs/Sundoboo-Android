package com.example.sundoboo.utils.navigation

import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.example.sundoboo.utils.fragment.FragmentItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

//TODO (2021.11.24) NavigationView와 Fragment 관리를 분리하기
class NavigationViewController(
    private val displayView: FragmentContainerView,
    private val navigation: BottomNavigationView,
    private val fragmentManager: FragmentManager,
) {

    fun setItemSelectedListener(listener: NavigationBarView.OnItemSelectedListener) {
        navigation.setOnItemSelectedListener(listener)
        navigation.setOnItemReselectedListener { }
    }

    fun replace(fragmentItem: FragmentItem) {
        fragmentManager.beginTransaction()
            .replace(displayView.id, fragmentItem.fragment, fragmentItem.tag)
            .apply {
                if (fragmentItem.shouldAddBackStack) {
                    addToBackStack(null)
                }
            }.commitAllowingStateLoss()
    }

}