package com.example.sundoboo.navigation

import androidx.fragment.app.Fragment

abstract class NavigationFragments {

    private val fragments: Map<Int, NavigationFragment> by lazy {
        createFragmentsWithId()
    }

    fun getFragmentMatchesMenuId(menuId: Int): Fragment {
        return fragments[menuId]?.fragment
            ?: throw Exception("Fragment with menuId $menuId not found!")
    }

    abstract fun createFragmentsWithId(): Map<Int, NavigationFragment>

}

data class NavigationFragment(
    val fragment: Fragment,
    val shouldAddBackStack: Boolean
)