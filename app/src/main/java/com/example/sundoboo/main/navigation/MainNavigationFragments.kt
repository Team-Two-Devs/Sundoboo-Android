package com.example.sundoboo.main.navigation

import com.example.sundoboo.R
import com.example.sundoboo.home.HomeFragment
import com.example.sundoboo.navigation.NavigationFragment
import com.example.sundoboo.navigation.NavigationFragments

class MainNavigationFragments : NavigationFragments() {

    private val feedFragment by lazy { HomeFragment.newInstance() }

    override fun createFragmentsWithId(): Map<Int, NavigationFragment> {
        return mutableMapOf(
            R.id.menu_item_feed to NavigationFragment(feedFragment, false)
        )
    }

}