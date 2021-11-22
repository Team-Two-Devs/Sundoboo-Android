package com.example.sundoboo.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sundoboo.utils.fragment.FragmentStore

class FeedFragmentAdapter(
    private val fragmentStore: FragmentStore<Int>,
    fragment: Fragment
) : FragmentStateAdapter(fragment.childFragmentManager, fragment.viewLifecycleOwner.lifecycle) {

    override fun getItemCount() = fragmentStore.size

    override fun createFragment(position: Int): Fragment {
        return fragmentStore.findFragmentByKey(position).fragment
    }

    fun updateCategories() {
        notifyDataSetChanged()
    }
}