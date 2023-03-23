package com.vb.numbersfacts.numberInput.widget

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.vb.numbersfacts.database.entity.NumberWithFact
import com.vb.numbersfacts.databinding.SearchHistoryItemViewBinding

class SearchHistoryItemView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding =
        SearchHistoryItemViewBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = binding.root.layoutParams
    }

    fun setItem(numberWithFact: NumberWithFact) {
        binding.searchHistoryItemNumber.text = numberWithFact.number.toString()
        binding.searchHistoryItemFact.text = numberWithFact.fact
    }
}
