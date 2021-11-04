package com.example.sundoboo.navigation

import com.example.sundoboo.R
import com.example.sundoboo.feed.FeedFragment

class MainNavigationFragments : NavigationFragments() {

    override val fragments: Map<Int, NavigationFragment>
        get() = createFragmentsWithId()

    private val feedFragment = FeedFragment.newInstance()

    private fun createFragmentsWithId() : Map<Int, NavigationFragment> {
        return mutableMapOf(
            R.id.menu_item_feed to NavigationFragment(feedFragment, false)
        )
    }

}