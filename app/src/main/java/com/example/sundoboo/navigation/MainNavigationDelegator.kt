package com.example.sundoboo.navigation

import android.content.Context
import androidx.fragment.app.Fragment

class MainNavigationDelegator(
    navigationViewController: NavigationViewController,
    navigationFragments: NavigationFragments,
    context: Context,
) : NavigationDelegator(navigationViewController, navigationFragments, context) {

    override fun mapFragment(id: Int): Fragment {
        return navigationFragments.getFragmentMatchesMenuId(id)
    }

}