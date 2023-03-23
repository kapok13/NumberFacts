package com.vb.numbersfacts.number.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.vb.numbersfacts.databinding.NumberFragmentBinding
import com.vb.numbersfacts.number.presentation.NumberViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NumberFragment : Fragment() {
    private val binding by lazy { NumberFragmentBinding.inflate(layoutInflater) }
    private val viewModel by viewModel<NumberViewModel>()
    private val args by navArgs<NumberFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = binding.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (args.number.isNullOrEmpty().not() && args.fact.isNullOrEmpty().not()) {
            binding.numberFact.text = args.fact
        } else {
            viewModel.getNumberFact(args.number?.toInt())
                .observe(viewLifecycleOwner) {
                    binding.numberFact.text = it.text
                    binding.numberNumber.text = it.number.toString()
                }
        }
    }
}
