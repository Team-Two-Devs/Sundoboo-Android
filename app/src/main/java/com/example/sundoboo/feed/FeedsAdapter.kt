package com.example.sundoboo.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemHomeFeedBinding
import com.example.sundoboo.feed.model.Feed

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
            binding.recyclerViewVotes.adapter = VotesAdapter()
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
