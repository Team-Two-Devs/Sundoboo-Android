package com.example.sundoboo

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainNavigationManager(
    displayView: FragmentContainerView,
    navigation: BottomNavigationView,
    fragmentManager: FragmentManager,
    context: Context,
) : NavigationManager(displayView, navigation, fragmentManager, context) {

    var fragmentSet = setOf<MappedFragment>()

    override fun mapFragment(id: Int): Fragment {
        return fragmentSet.single {
            it.menuId == id
        }.fragment
    }

}

data class MappedFragment(
    val fragment: Fragment,
    val menuId: Int,
)