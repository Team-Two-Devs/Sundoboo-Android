package com.example.sundoboo.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sundoboo.databinding.FragmentFeedBinding
import com.example.sundoboo.home.model.Category
import com.example.sundoboo.utils.autoCleared
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedFragment : Fragment() {

    private var binding by autoCleared<FragmentFeedBinding>()

    private val viewModel: FeedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(layoutInflater).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = this@FeedFragment.viewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()

        observeViewModel()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewFeeds.adapter = FeedsAdapter()
    }

    private fun observeViewModel() {

    }

    companion object {
        const val KEY_CATEGORY = "KEY_CATEGORY"

        @JvmStatic
        fun newInstance(category: Category) = FeedFragment().apply {
            arguments = Bundle().apply {
                putSerializable(KEY_CATEGORY, category)
            }
        }
    }
}