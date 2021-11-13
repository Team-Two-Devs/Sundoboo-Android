package com.example.sundoboo.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ActivitySearchFeedsBinding

class SearchFeedsActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySearchFeedsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_feeds)

        setUpToolbar()
    }

    private fun setUpToolbar() {
        binding.toolBar.setNavigationOnClickListener {
            finish()
        }
    }

    companion object {
        @JvmStatic
        fun newIntent(context: Context): Intent {
            return Intent(context, SearchFeedsActivity::class.java)
        }
    }

}