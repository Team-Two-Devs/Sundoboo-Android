package com.example.sundoboo.search

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemSearchHistoryBinding
import com.example.sundoboo.search.model.SearchHistory

class SearchHistoriesAdapter :
    RecyclerView.Adapter<SearchHistoriesAdapter.SearchHistoriesViewHolder>() {

    private var searchHistories: List<SearchHistory> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoriesViewHolder {
        return SearchHistoriesViewHolder(
            ItemSearchHistoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: SearchHistoriesViewHolder, position: Int) {
        holder.bind(searchHistories[position])
    }

    override fun getItemCount() = searchHistories.size

    @SuppressLint("NotifyDataSetChanged")
    fun updateAll(histories: List<SearchHistory>) {
        searchHistories = histories
        notifyDataSetChanged()
    }

    class SearchHistoriesViewHolder(private val binding: ItemSearchHistoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: SearchHistory) {
            binding.item = item
        }

    }

}

@BindingAdapter("searchHistories")
fun setSearchHistories(recyclerView: RecyclerView, histories: List<SearchHistory>?) {
    histories ?: return
    (recyclerView.adapter as SearchHistoriesAdapter).updateAll(histories)
}
