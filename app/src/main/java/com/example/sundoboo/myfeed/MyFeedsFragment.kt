package com.example.sundoboo.myfeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.databinding.FragmentMyFeedsBinding
import com.example.sundoboo.utils.autoCleared

class MyFeedsFragment : Fragment() {

    private var binding by autoCleared<FragmentMyFeedsBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyFeedsBinding.inflate(inflater)
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyFeedsFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }
}