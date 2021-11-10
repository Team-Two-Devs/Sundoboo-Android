package com.example.sundoboo.navigation

import androidx.fragment.app.Fragment

abstract class FragmentsStore {

    private val fragments: Map<Int, NavigationFragment> by lazy {
        createFragmentsWithId()
    }

    val size: Int
        get() = fragments.size

    fun getFragmentMatchesMenuId(menuId: Int): NavigationFragment {
        return fragments[menuId]
            ?: throw Exception("Fragment with menuId $menuId not found!")
    }

    abstract fun createFragmentsWithId(): Map<Int, NavigationFragment>

}

data class NavigationFragment(
    val tag: String,
    val fragment: Fragment,
    val shouldAddBackStack: Boolean
)