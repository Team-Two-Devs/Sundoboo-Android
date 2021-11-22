package com.example.sundoboo.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sundoboo.databinding.FragmentHomeBinding
import com.example.sundoboo.feed.list.FeedFragment
import com.example.sundoboo.home.model.Category
import com.example.sundoboo.search.SearchFeedsActivity
import com.example.sundoboo.utils.autoCleared
import com.example.sundoboo.utils.fragment.FragmentItem
import com.example.sundoboo.utils.fragment.FragmentStore
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var binding by autoCleared<FragmentHomeBinding>()

    private val viewModel by viewModels<HomeViewModel>()

    private lateinit var feedFragmentAdapter: FeedFragmentAdapter

    private val fragmentStore: FragmentStore<Int> by lazy {
        FragmentStore()
    }

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
        setUpToolbar()

        observeViewModel()
    }

    private fun setUpViewPager() {
        feedFragmentAdapter = FeedFragmentAdapter(fragmentStore, this)
        binding.viewPagerFeed.adapter = feedFragmentAdapter
    }

    private fun setUpToolbar() {
        binding.toolbarSearch.setOnClickListener {
            startActivity(SearchFeedsActivity.newIntent(requireContext()))
        }
    }

    private fun observeViewModel() {
        viewModel.categories.observe(viewLifecycleOwner) {
            attachTabLayout(it)
            updateCategories(it)
        }
    }

    private fun attachTabLayout(categories: List<Category>) {
        TabLayoutMediator(
            binding.tabLayoutCategory,
            binding.viewPagerFeed
        ) { tabLayout, position ->
            tabLayout.text = categories[position].name
        }.attach()
    }

    private fun updateCategories(categories: List<Category>) {
        fragmentStore.changeFragments(
            categories.mapIndexed { position, category ->
                position to FragmentItem(category.name, FeedFragment.newInstance(category))
            }.toMap()
        )
        feedFragmentAdapter.updateCategories()
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}