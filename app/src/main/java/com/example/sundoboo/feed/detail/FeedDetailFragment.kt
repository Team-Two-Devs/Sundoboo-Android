package com.example.sundoboo.feed.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.R
import com.example.sundoboo.databinding.FragmentFeedDetailBinding
import com.example.sundoboo.feed.model.FeedItem
import com.example.sundoboo.utils.autoCleared

class FeedDetailFragment : Fragment() {

    private var binding by autoCleared<FragmentFeedDetailBinding>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFeedDetailBinding.inflate(inflater)
        return binding.root
    }

    companion object {

        const val FEED_ID = "FEED_ID"

        @JvmStatic
        fun newInstance(feed: FeedItem) = FeedDetailFragment().apply {
            arguments = Bundle().apply {
                putString(FEED_ID, feed.id)
            }
        }
    }
}