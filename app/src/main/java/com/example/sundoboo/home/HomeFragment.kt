package com.example.sundoboo.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sundoboo.databinding.FragmentHomeBinding
import com.example.sundoboo.utils.autoCleared
import com.google.android.material.tabs.TabLayoutMediator

class HomeFragment : Fragment() {

    private var binding by autoCleared<FragmentHomeBinding>()

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var feedFragmentAdapter: FeedFragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater).apply {
            lifecycleOwner = this@HomeFragment.viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViewPager()

        observeViewModel()
    }

    private fun setUpViewPager() {
        feedFragmentAdapter = FeedFragmentAdapter(this)
        binding.viewPagerFeed.adapter = feedFragmentAdapter
    }

    private fun observeViewModel() {
        viewModel.categories.observe(viewLifecycleOwner) {
            TabLayoutMediator(binding.tabLayoutCategory, binding.viewPagerFeed) { tabLayout, position ->
                tabLayout.text = it[position].name
            }.attach()
            feedFragmentAdapter.updateCategories(it)
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}