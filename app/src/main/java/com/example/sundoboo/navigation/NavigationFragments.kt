package com.example.sundoboo.navigation

import androidx.fragment.app.Fragment

abstract class NavigationFragments {

    protected abstract val fragments: Map<Int, NavigationFragment>

    fun getFragmentMatchesMenuId(menuId: Int): Fragment {
        return fragments[menuId]?.fragment ?: throw Exception("Fragment with menuId $menuId not found!")
    }

}

data class NavigationFragment(
    val fragment: Fragment,
    val shouldAddBackStack: Boolean
)