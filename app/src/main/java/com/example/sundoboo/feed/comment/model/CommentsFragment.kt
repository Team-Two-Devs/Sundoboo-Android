package com.example.sundoboo.feed.comment.model

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.R
import com.example.sundoboo.databinding.FragmentCommentsBinding
import com.example.sundoboo.utils.autoCleared

private const val FEED_ID = "param1"

class CommentsFragment : Fragment() {

    private var binding by autoCleared<FragmentCommentsBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCommentsBinding.inflate(inflater)
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(feedId: String) = CommentsFragment().apply {
            arguments = Bundle().apply {
                putString(FEED_ID, feedId)
            }
        }
    }
}