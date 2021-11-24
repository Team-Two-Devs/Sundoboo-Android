package com.example.sundoboo.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivitySearchFeedsBinding
import com.example.sundoboo.utils.showKeyboardAndFocus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFeedsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchFeedsBinding

    private val viewModel: SearchFeedsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_feeds)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        setUpToolbar()
        setUpRecyclerViewSearchHistory()
    }

    override fun onResume() {
        super.onResume()
        binding.editTextSearch.showKeyboardAndFocus()
    }

    private fun setUpToolbar() {
        binding.toolBar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setUpRecyclerViewSearchHistory() {
        binding.recyclerViewSearchHistories.setHasFixedSize(true)
        binding.recyclerViewSearchHistories.adapter = SearchHistoriesAdapter()
    }

    companion object {
        @JvmStatic
        fun newIntent(context: Context): Intent {
            return Intent(context, SearchFeedsActivity::class.java)
        }
    }

}