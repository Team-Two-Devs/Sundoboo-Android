package com.example.sundoboo.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.R
import com.example.sundoboo.databinding.ItemHomeFeedBinding
import com.example.sundoboo.feed.model.Feed
import com.example.sundoboo.vote.Vote

class FeedsAdapter : ListAdapter<Feed, FeedsAdapter.FeedsViewHolder>(FeedDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        return FeedsViewHolder(
            ItemHomeFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeedsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateFeeds(newFeeds: List<Feed>) {
        submitList(newFeeds)
    }

    fun replaceFeeds(newFeeds: List<Feed>) {
        submitList(null)
        submitList(newFeeds)
    }

    class FeedsViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Feed) {
            binding.item = item
        }

    }

    object FeedDiffUtil : DiffUtil.ItemCallback<Feed>() {
        override fun areItemsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Feed, newItem: Feed): Boolean {
            return oldItem == newItem
        }

    }

}

@BindingAdapter("feeds")
fun setFeeds(recyclerView: RecyclerView, feeds: List<Feed>?) {
    feeds ?: return
    (recyclerView.adapter as FeedsAdapter).replaceFeeds(feeds)
}

@BindingAdapter("votes")
fun setVotes(radioGroup: RadioGroup, votes: List<Vote>?) {
    votes ?: return
    val context = radioGroup.context

    votes.run {
        radioGroup.removeAllViews()

        map {
            radioGroup.addView(RadioButton(context).apply {
                layoutParams = RadioGroup.LayoutParams(
                    RadioGroup.LayoutParams.MATCH_PARENT,
                    RadioGroup.LayoutParams.WRAP_CONTENT
                )
                isChecked = it.checked
                text = it.description
                setTextAppearance(R.style.RadioButtonText)
                buttonDrawable = ContextCompat.getDrawable(context, R.drawable.background_feed_vote)
                setPadding(20, 20, 20, 20)
            })
        }
    }
}