package com.example.sundoboo.main.navigation

import com.example.sundoboo.R
import com.example.sundoboo.feed.FeedFragment
import com.example.sundoboo.navigation.NavigationFragment
import com.example.sundoboo.navigation.NavigationFragments

class MainNavigationFragments : NavigationFragments() {

    private val feedFragment by lazy { FeedFragment.newInstance() }

    override fun createFragmentsWithId(): Map<Int, NavigationFragment> {
        return mutableMapOf(
            R.id.menu_item_feed to NavigationFragment(feedFragment, false)
        )
    }

}