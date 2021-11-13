package com.example.sundoboo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivityMainBinding
import com.example.sundoboo.home.HomeFragment
import com.example.sundoboo.utils.fragment.FragmentItem
import com.example.sundoboo.utils.fragment.FragmentStoreBuilder
import com.example.sundoboo.utils.navigation.NavigationViewManager
import com.example.sundoboo.utils.navigation.NavigationViewController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationViewManager: NavigationViewManager

    private val navigationViewController by lazy {
        NavigationViewController(
            displayView = binding.fragmentContainerView,
            navigation = binding.bottomNavigationView,
            fragmentManager = supportFragmentManager
        )
    }

    private val homeFragment by lazy { HomeFragment.newInstance() }

    private val fragments by lazy {
        mapOf(
            R.id.menu_item_home to FragmentItem("home", homeFragment, false),
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {
        navigationViewManager = NavigationViewManager(
            context = this,
            navigationViewController = navigationViewController,
            fragmentStore = FragmentStoreBuilder<Int>().with(fragments).build()
        )

        navigationViewManager.start(R.id.menu_item_home)
    }
}