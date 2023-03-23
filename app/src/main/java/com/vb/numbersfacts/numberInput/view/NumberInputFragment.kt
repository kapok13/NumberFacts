package com.vb.numbersfacts.numberInput.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.vb.numbersfacts.MainNavGraphDirections
import com.vb.numbersfacts.databinding.NumberInputFragmentBinding
import com.vb.numbersfacts.numberInput.presentation.NumberInputViewModel
import com.vb.numbersfacts.numberInput.widget.SearchHistoryAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class NumberInputFragment : Fragment() {
    private val binding by lazy { NumberInputFragmentBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<NumberInputViewModel>()
    private val adapter = SearchHistoryAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.numberInputNumber.doOnTextChanged { text, _, _, _ ->
            binding.findFactButton.isEnabled = text.isNullOrEmpty().not()
        }
        binding.findFactButton.setOnClickListener {
            findNavController().navigate(MainNavGraphDirections.tuNumberFragment(binding.numberInputNumber.text.toString(), null))
            binding.numberInputNumber.text.clear()
            binding.findFactButton.isEnabled = false
        }
        binding.findRandomFactButton.setOnClickListener {
            findNavController().navigate(MainNavGraphDirections.tuNumberFragment(null, null))
        }
        viewModel.getNumberWithFacts().observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        adapter.onItemClickListener = {
            findNavController().navigate(MainNavGraphDirections.tuNumberFragment(it.number.toString(), it.fact))
        }
        binding.searchHistoryRecycler.adapter = adapter
    }
}
