package com.example.sundoboo.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.sundoboo.feed.FeedFragment
import com.example.sundoboo.home.model.Category

class FeedFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    private var categories = listOf<Category>()

    override fun getItemCount() = categories.size

    override fun createFragment(position: Int): Fragment {
        return FeedFragment.newInstance(categories[position])
    }

    fun updateCategories(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}