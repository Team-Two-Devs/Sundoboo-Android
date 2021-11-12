package com.example.sundoboo.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.databinding.FragmentFeedBinding
import com.example.sundoboo.home.model.Category
import com.example.sundoboo.utils.autoCleared

class FeedFragment : Fragment() {

    private var binding by autoCleared<FragmentFeedBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewFeeds.adapter = FeedsAdapter()
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