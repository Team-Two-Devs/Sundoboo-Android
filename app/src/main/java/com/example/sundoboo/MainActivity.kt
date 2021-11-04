package com.example.sundoboo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.databinding.ActivityMainBinding
import com.example.sundoboo.navigation.MainNavigationDelegator
import com.example.sundoboo.navigation.MainNavigationFragments
import com.example.sundoboo.navigation.NavigationDelegator
import com.example.sundoboo.navigation.NavigationViewController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationDelegator: NavigationDelegator

    private val navigationFragments by lazy {
        MainNavigationFragments()
    }

    private val navigationViewController by lazy {
        NavigationViewController(
            displayView = binding.fragmentContainerView,
            navigation = binding.bottomNavigationView,
            fragmentManager = supportFragmentManager
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {
        navigationDelegator = MainNavigationDelegator(
            context = this,
            navigationViewController = navigationViewController,
            navigationFragments = navigationFragments
        )

        navigationDelegator.startWith(R.id.menu_item_feed)
    }
}