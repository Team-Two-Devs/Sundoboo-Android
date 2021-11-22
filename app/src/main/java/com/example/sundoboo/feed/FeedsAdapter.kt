package com.example.sundoboo.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemHomeFeedBinding
import com.example.sundoboo.feed.model.FeedItem
import com.example.sundoboo.vote.VotesAdapter

class FeedsAdapter : ListAdapter<FeedItem, FeedsAdapter.FeedsViewHolder>(FeedDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        return FeedsViewHolder(
            ItemHomeFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeedsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    fun updateFeeds(newFeedItems: List<FeedItem>) {
        submitList(newFeedItems)
    }

    fun replaceFeeds(newFeedItems: List<FeedItem>) {
        submitList(null)
        submitList(newFeedItems)
    }

    class FeedsViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: FeedItem) {
            binding.recyclerViewVotes.adapter = VotesAdapter()
            binding.item = item
        }

    }

    object FeedDiffUtil : DiffUtil.ItemCallback<FeedItem>() {
        override fun areItemsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: FeedItem, newItem: FeedItem): Boolean {
            return oldItem == newItem
        }

    }

}

@BindingAdapter("feeds")
fun setFeeds(recyclerView: RecyclerView, feedItems: List<FeedItem>?) {
    feedItems ?: return
    (recyclerView.adapter as FeedsAdapter).replaceFeeds(feedItems)
}
