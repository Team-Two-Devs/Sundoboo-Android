package com.example.sundoboo.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sundoboo.feed.FeedFragment
import com.example.sundoboo.home.model.Category
import com.example.sundoboo.utils.fragment.FragmentItem
import com.example.sundoboo.utils.fragment.FragmentStore

class FeedFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private val fragmentStore = FragmentStore<Int>()

    override fun getItemCount() = fragmentStore.size

    override fun createFragment(position: Int): Fragment {
        return fragmentStore.findFragmentByKey(position).fragment
    }

    fun updateCategories(categories: List<Category>) {
        fragmentStore.changeFragments(
            categories.mapIndexed { index, it ->
                index to FragmentItem(it.name, FeedFragment.newInstance(it))
            }.toMap()
        )
        notifyDataSetChanged()
    }
}