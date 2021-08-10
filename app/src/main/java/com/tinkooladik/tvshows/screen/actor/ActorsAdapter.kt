package com.tinkooladik.tvshows.screen.actor

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.bumptech.glide.Glide
import com.tinkooladik.tvshows.R
import com.tinkooladik.tvshows.base.BaseAdapter
import com.tinkooladik.tvshows.base.ListViewHolder
import com.tinkooladik.tvshows.databinding.ItemActorBinding
import com.tinkooladik.tvshows.domain.actor.Actor
import com.tinkooladik.tvshows.extentions.inflate

class ActorsAdapter(
    private val onItemClicked: (value: Actor) -> Unit
) : BaseAdapter<Actor>(diffUtilCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(parent.inflate(R.layout.item_actor))
    }

    inner class ActorViewHolder(itemView: View) : ListViewHolder<Actor>(itemView) {

        private val binding = ItemActorBinding.bind(itemView)

        override fun onBind(item: Actor) {
            binding.root.setOnClickListener {
                onItemClicked(item)
            }

            binding.name.text = item.name
            Glide.with(binding.image).load(item.imageUrl).into(binding.image)
        }
    }

    companion object {
        val diffUtilCallback = object : DiffUtil.ItemCallback<Actor>() {
            override fun areItemsTheSame(oldItem: Actor, newItem: Actor): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: Actor, newItem: Actor): Boolean {
                return oldItem == newItem
            }
        }
    }
}