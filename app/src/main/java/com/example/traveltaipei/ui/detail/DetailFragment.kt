package com.example.traveltaipei.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.traveltaipei.databinding.FragmentDetailBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by viewModels()
//    private val viewModel by viewModels<DetailViewModel>()

    val arg: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.model = viewModel
        binding.data = arg.data

        lifecycleScope.launch {
            viewModel.route.collect { route ->
                when (route) {
                    DetailViewModel.DetailRoute.GoBack -> {
                        findNavController().popBackStack()
                    }
                }
            }
        }

        return binding.root
    }
}