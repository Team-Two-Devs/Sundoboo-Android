package com.example.sundoboo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationManager: NavigationManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {
        navigationManager = MainNavigationManager(
            displayView = binding.fragmentContainerView,
            navigation = binding.bottomNavigationView,
            fragmentManager = supportFragmentManager,
            context = this
        ).apply {
            fragmentSet
        }
    }
}