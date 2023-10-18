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
import androidx.viewpager2.widget.ViewPager2
import com.example.traveltaipei.databinding.FragmentDetailBinding
import com.example.traveltaipei.ui.attractions.AttractionsFragmentDirections
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class DetailFragment : Fragment() {

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by viewModels()
//    private val viewModel by viewModels<DetailViewModel>()

    private val arg: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentDetailBinding.inflate(inflater, container, false)
        val data = arg.data
        binding.lifecycleOwner = this
        binding.model = viewModel
        binding.data = data

        val mAdapter = DetailPhotoAdapter()
        binding.viewPagerDetailImg.adapter = mAdapter
        mAdapter.submitList(data.images)

        lifecycleScope.launch {
            viewModel.route.collect { route ->
                when (route) {
                    DetailViewModel.DetailRoute.GoBack -> {
                        findNavController().popBackStack()
                    }
                    is DetailViewModel.DetailRoute.GoToWebView -> {
                        if (route.url.isNotBlank()) {
                            findNavController().navigate(
                                DetailFragmentDirections.actionDetailFragmentToWebViewFragment(route.url)
                            )
                        }
                    }
                }
            }
        }

        return binding.root
    }
}