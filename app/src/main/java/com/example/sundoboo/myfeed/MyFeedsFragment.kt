package com.example.sundoboo.myfeed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.databinding.FragmentMyFeedsBinding
import com.example.sundoboo.utils.autoCleared

//TODO 2021.11.22 기획이 없어 더 이상 진행할 수 없는 상태. 조금이라도 틀이 잡힌 피드 상세화면을 먼저 작업하기로 결정.
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