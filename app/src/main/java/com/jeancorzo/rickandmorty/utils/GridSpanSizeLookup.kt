package com.jeancorzo.rickandmorty.utils

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GridSpanSizeLookup<LA : RecyclerView.Adapter<*>, FA: RecyclerView.Adapter<*>>(
    private val span: Int,
    private val listAdapter: LA,
    private val footerAdapter: FA
) : GridLayoutManager.SpanSizeLookup() {
    override fun getSpanSize(position: Int): Int {
        return if (position == listAdapter.itemCount && footerAdapter.itemCount > 0) {
            span
        } else {
            1
        }
    }

}