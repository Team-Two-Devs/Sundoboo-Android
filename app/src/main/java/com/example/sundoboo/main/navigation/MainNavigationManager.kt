package com.example.sundoboo.main.navigation

import android.content.Context
import com.example.sundoboo.navigation.NavigationFragments
import com.example.sundoboo.navigation.NavigationManager
import com.example.sundoboo.navigation.NavigationViewController

class MainNavigationManager(
    navigationViewController: NavigationViewController,
    navigationFragments: NavigationFragments,
    context: Context,
) : NavigationManager(navigationViewController, navigationFragments, context) {

}