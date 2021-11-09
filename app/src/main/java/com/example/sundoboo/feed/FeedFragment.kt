package com.example.sundoboo.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.sundoboo.R
import com.example.sundoboo.home.model.Category

class FeedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_feed, container, false)
    }

    companion object {

        const val KEY_CATEGORY = "KEY_CATEGORY"

        @JvmStatic
        fun newInstance(category: Category) =
            FeedFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(KEY_CATEGORY ,category)
                }
            }
    }
}