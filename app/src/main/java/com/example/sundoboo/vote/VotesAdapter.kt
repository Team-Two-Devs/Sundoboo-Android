package com.example.sundoboo.vote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemVoteBinding
import com.example.sundoboo.vote.Vote

class VotesAdapter : RecyclerView.Adapter<VotesAdapter.VotesViewHolder>() {

    var items = listOf<Vote>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VotesViewHolder(
        ItemVoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VotesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class VotesViewHolder(private val binding: ItemVoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Vote) {
            binding.item = item
        }
    }

}

@BindingAdapter("votes")
fun setVotes(recyclerView: RecyclerView, votes: List<Vote>?) {
    votes ?: return
    recyclerView.run {
        if (adapter == null) {
            adapter = VotesAdapter()
        }

        (adapter as VotesAdapter).run {
            items = votes
            notifyDataSetChanged()
        }
    }
}
