package com.tinkooladik.tvshows.base

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<T : Any>(diffUtil: DiffUtil.ItemCallback<T>) :
    ListAdapter<T, ListViewHolder<T>>(diffUtil) {

    override fun onBindViewHolder(holder: ListViewHolder<T>, position: Int) {
        holder.bind(getItem(position))
    }
}