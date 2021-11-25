package com.example.sundoboo.feed.comment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.R
import com.example.sundoboo.databinding.FragmentCommentsBinding
import com.example.sundoboo.feed.comment.CommentsAdapter
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        binding.recyclerViewComments.adapter = CommentsAdapter()
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