package com.midterm.cryptonews.ui.dashboard.source

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.midterm.cryptonews.databinding.NewsItemBinding
import com.midterm.cryptonews.models.NewsModel

class NewsAdapter : PagingDataAdapter<NewsModel.Result, NewsAdapter.UserViewHolder>(
    DiffCallback()
) {

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.onBind()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = UserViewHolder(
        NewsItemBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
    )

    inner class UserViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        private var news: NewsModel.Result? = null
        fun onBind() {
            Log.d("user",news.toString())
            this.news = getItem(bindingAdapterPosition)
            binding.tvTitle.text = news!!.title
            binding.tvDesc.text = news!!.description
        }
    }
}
class DiffCallback : DiffUtil.ItemCallback<NewsModel.Result>() {
    override fun areItemsTheSame(oldItem: NewsModel.Result, newItem: NewsModel.Result) =
        oldItem.title == newItem.title
    override fun areContentsTheSame(oldItem: NewsModel.Result, newItem: NewsModel.Result) = oldItem != newItem

}