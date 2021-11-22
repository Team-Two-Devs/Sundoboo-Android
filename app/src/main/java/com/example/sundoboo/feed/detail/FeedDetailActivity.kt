package com.example.sundoboo.feed.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivityFeedDetailBinding
import com.example.sundoboo.feed.model.FeedItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FeedDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedDetailBinding

    private val viewModel by viewModels<FeedDetailViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_feed_detail)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    companion object {

        const val FEED_ID = "FEED_ID"

        @JvmStatic
        fun newIntent(context: Context, feed: FeedItem) = Intent(context, FeedDetailActivity::class.java).apply {
            putExtra(FEED_ID, feed.id)
        }
    }
}