package com.example.sundoboo.feed

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemVoteBinding
import com.example.sundoboo.vote.Vote

class VotesAdapter : RecyclerView.Adapter<VotesAdapter.VotesViewHolder>() {

    //set이 부수 효과를 일으키고 있음. 메소드로 분리 필요.
    var items = listOf<Vote>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class VotesViewHolder(private val binding: ItemVoteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Vote) {
            binding.item = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = VotesViewHolder(
        ItemVoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: VotesViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

}

@BindingAdapter("votes")
fun setVotes(recyclerView: RecyclerView, votes: List<Vote>?) {
    votes ?: return
    recyclerView.run {
        if (adapter == null) {
            adapter = VotesAdapter()
        }

        (adapter as VotesAdapter).items = votes
    }
}
