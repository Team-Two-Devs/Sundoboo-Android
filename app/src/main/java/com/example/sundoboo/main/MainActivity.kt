package com.example.sundoboo.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivityMainBinding
import com.example.sundoboo.main.navigation.MainNavigationManager
import com.example.sundoboo.main.navigation.MainFragmentsStore
import com.example.sundoboo.navigation.NavigationManager
import com.example.sundoboo.navigation.NavigationViewController

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationManager: NavigationManager

    private val navigationFragments by lazy {
        MainFragmentsStore()
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
        navigationManager = MainNavigationManager(
            context = this,
            navigationViewController = navigationViewController,
            fragmentsStore = navigationFragments
        )

        navigationManager.start(R.id.menu_item_home)
    }
}