package com.example.sundoboo.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.sundoboo.databinding.FragmentHomeBinding
import com.example.sundoboo.utils.autoCleared
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private var binding by autoCleared<FragmentHomeBinding>()

    private val viewModel by viewModels<FeedViewModel>()

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

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.tabItems.observe(viewLifecycleOwner) { tabs ->

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