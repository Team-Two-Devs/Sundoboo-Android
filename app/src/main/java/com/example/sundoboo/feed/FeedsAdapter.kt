package com.example.sundoboo.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemHomeFeedBinding

class FeedsAdapter : RecyclerView.Adapter<FeedsAdapter.FeedsViewHolder>() {

    private val feeds: MutableList<Feed> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedsViewHolder {
        return FeedsViewHolder(
            ItemHomeFeedBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: FeedsViewHolder, position: Int) {
        holder.bind(feeds[position])
    }

    override fun getItemCount() = feeds.size

    fun updateFeeds(newFeeds: List<Feed>) {
        feeds.addAll(newFeeds)
        notifyDataSetChanged()
    }

    fun replaceFeeds(newFeeds: List<Feed>) {
        feeds.clear()
        feeds.addAll(newFeeds)
        notifyDataSetChanged()
    }

    class FeedsViewHolder(private val binding: ItemHomeFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Feed) {
            binding.item = item
        }

    }

}

@BindingAdapter("feeds")
fun setFeeds(recyclerView: RecyclerView, feeds: List<Feed>?) {
    feeds ?: return
    (recyclerView.adapter as FeedsAdapter).replaceFeeds(feeds)
}