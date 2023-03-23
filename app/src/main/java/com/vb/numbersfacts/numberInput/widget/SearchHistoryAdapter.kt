package com.vb.numbersfacts.numberInput.widget

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.vb.numbersfacts.database.entity.NumberWithFact

class SearchHistoryAdapter : ListAdapter<NumberWithFact, SearchHistoryViewHolder>(
    object : DiffUtil.ItemCallback<NumberWithFact>() {
        override fun areItemsTheSame(oldItem: NumberWithFact, newItem: NumberWithFact): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NumberWithFact, newItem: NumberWithFact): Boolean {
            return oldItem.number == newItem.number
        }
    }
) {
    var onItemClickListener: ((NumberWithFact) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHistoryViewHolder =
        SearchHistoryViewHolder(SearchHistoryItemView(parent.context))

    override fun onBindViewHolder(holder: SearchHistoryViewHolder, position: Int) {
        with(holder.itemView as SearchHistoryItemView) {
            setOnClickListener { onItemClickListener?.invoke(getItem(position)) }
            setItem(getItem(position))
        }
    }
}
