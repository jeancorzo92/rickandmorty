package com.jeancorzo.rickandmorty.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.annotation.IntegerRes
import androidx.recyclerview.widget.RecyclerView

class ItemOffsetDecoration(context: Context, @DimenRes itemOffset: Int) : RecyclerView.ItemDecoration() {

    private val mItemOffset = context.resources.getDimensionPixelSize(itemOffset)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset)
    }
}