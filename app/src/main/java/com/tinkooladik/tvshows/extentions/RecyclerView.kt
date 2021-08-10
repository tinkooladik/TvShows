package com.tinkooladik.tvshows.extentions

import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tinkooladik.tvshows.R

fun RecyclerView.addVerticalSpacingItemDecoration(
    @DimenRes spacing: Int = R.dimen.spacing_medium
) {
    val stackFromEnd = (layoutManager as? LinearLayoutManager)?.stackFromEnd ?: false
    addItemDecoration(
        object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                if (stackFromEnd) outRect.top = context.resources.getDimensionPixelSize(spacing)
                else outRect.bottom = context.resources.getDimensionPixelSize(spacing)
            }
        }
    )
}

fun RecyclerView.addHorizontalSpacingItemDecoration(
    @DimenRes spacing: Int = R.dimen.spacing_medium
) {
    addItemDecoration(
        object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                val halfSpace = context.resources.getDimensionPixelSize(spacing) / 2
                outRect.left = halfSpace
                outRect.right = halfSpace
            }
        }
    )
}