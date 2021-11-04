package com.example.sundoboo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var navigationDelegator: NavigationDelegator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpBottomNavigationView()
    }

    private fun setUpBottomNavigationView() {
        navigationDelegator = MainNavigationDelegator(
            displayView = binding.fragmentContainerView,
            navigation = binding.bottomNavigationView,
            fragmentManager = supportFragmentManager,
            context = this
        ).apply {
            fragmentSet
        }
    }
}