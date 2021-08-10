package com.tinkooladik.tvshows.screen.home

import android.annotation.SuppressLint
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.tinkooladik.tvshows.R
import com.tinkooladik.tvshows.base.BaseAdapter
import com.tinkooladik.tvshows.base.ListViewHolder
import com.tinkooladik.tvshows.databinding.ItemShowBinding
import com.tinkooladik.tvshows.domain.show.Show
import com.tinkooladik.tvshows.extentions.inflate
import java.time.format.DateTimeFormatter

class ShowsAdapter(
    private val onItemClicked: (value: Show) -> Unit
) : BaseAdapter<Show>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShowViewHolder {
        return ShowViewHolder(parent.inflate(R.layout.item_show))
    }

    inner class ShowViewHolder(itemView: View) : ListViewHolder<Show>(itemView) {

        private val binding = ItemShowBinding.bind(itemView)

        override fun onBind(item: Show) {
            binding.root.setOnClickListener {
                onItemClicked(item)
            }

            binding.title.text = item.title
            binding.releaseDate.text = item.releaseDate.format(dateFormat)

            Glide.with(binding.pic).load(item.imageUrl).into(binding.pic)
        }
    }

    companion object {
        val diffUtilCallback = object : DiffUtil.ItemCallback<Show>() {
            override fun areItemsTheSame(oldItem: Show, newItem: Show): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Show, newItem: Show): Boolean {
                return oldItem == newItem
            }
        }

        @SuppressLint("SimpleDateFormat")
        val dateFormat: DateTimeFormatter = DateTimeFormatter.ofPattern("MMM yyyy")
    }
}