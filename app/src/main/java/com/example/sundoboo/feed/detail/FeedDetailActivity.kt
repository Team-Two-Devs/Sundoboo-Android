package com.example.sundoboo.feed.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivityFeedDetailBinding
import com.example.sundoboo.feed.model.FeedItem
import dagger.hilt.android.AndroidEntryPoint

/*
    TODO 2021.11.22
    11.23) 2번 항목 수정.
    1) 디자인 개선
    2) 피드 작성자용 화면을 Fragment로 분리 시킬지 고민 중...
    3) 댓글 목록 추가
    4) Writer 비교 추가
    5) User 추가
    ...
 */
const val FEED_ID = "FEED_ID"

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

        @JvmStatic
        fun newIntent(context: Context, feed: FeedItem) = Intent(context, FeedDetailActivity::class.java).apply {
            putExtra(FEED_ID, feed.id)
        }
    }
}