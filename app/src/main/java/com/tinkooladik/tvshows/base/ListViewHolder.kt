package com.tinkooladik.tvshows.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ListViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var boundItem: T? = null
        private set

    protected abstract fun onBind(item: T)

    internal fun bind(item: T) {
        onBind(item)
        boundItem = item
    }
}