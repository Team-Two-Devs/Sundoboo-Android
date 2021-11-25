package com.example.sundoboo.feed.comment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sundoboo.databinding.ItemCommentBinding
import com.example.sundoboo.feed.comment.model.Comment

class CommentsAdapter : ListAdapter<Comment, CommentsAdapter.CommentsViewHolder>(CommentsDiffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CommentsViewHolder(
        ItemCommentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CommentsViewHolder(private val binding: ItemCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Comment) {
            binding.item = item
        }

    }

}

@BindingAdapter("comments")
fun setComments(recyclerView: RecyclerView, comments: List<Comment>?) {
    recyclerView.adapter ?: return
    comments ?: return

    (recyclerView.adapter as CommentsAdapter).submitList(comments)
}

object CommentsDiffUtil : DiffUtil.ItemCallback<Comment>() {

    override fun areItemsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Comment, newItem: Comment): Boolean {
        return oldItem.id == newItem.id
    }

}
