package com.example.sundoboo.main.navigation

import android.content.Context
import com.example.sundoboo.navigation.FragmentsStore
import com.example.sundoboo.navigation.NavigationManager
import com.example.sundoboo.navigation.NavigationViewController

class MainNavigationManager(
    navigationViewController: NavigationViewController,
    fragmentsStore: FragmentsStore,
    context: Context,
) : NavigationManager(navigationViewController, fragmentsStore, context) {

}