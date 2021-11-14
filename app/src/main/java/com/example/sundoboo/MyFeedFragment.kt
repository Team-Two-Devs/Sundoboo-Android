package com.example.sundoboo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.databinding.FragmentMyFeedBinding
import com.example.sundoboo.utils.autoCleared

class MyFeedFragment : Fragment() {

    private var binding by autoCleared<FragmentMyFeedBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyFeedBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFeedFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}