package com.example.sundoboo.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sundoboo.R
import com.example.sundoboo.databinding.FragmentFeedBinding
import com.example.sundoboo.utils.autoCleared

class FeedFragment : Fragment() {

    private var binding by autoCleared<FragmentFeedBinding>()

    private val viewModel by viewModels<FeedViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.tabItems.observe(viewLifecycleOwner) { tabs ->

        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = FeedFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}