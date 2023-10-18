package com.example.traveltaipei.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.traveltaipei.databinding.FragmentWebViewBinding
import com.example.traveltaipei.ui.detail.DetailFragmentArgs

class WebViewFragment : Fragment() {

    lateinit var binding: FragmentWebViewBinding
    private val arg: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWebViewBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.webViewDetail.loadUrl(arg.data.url)

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = WebViewFragment()
    }
}