package com.example.traveltaipei.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    private val _route = Channel<DetailRoute>()
    val route = _route.receiveAsFlow()

    fun goBack() {
        viewModelScope.launch {
            _route.send(DetailRoute.GoBack)
        }
    }

    fun goToWebView(url: String) {
        viewModelScope.launch {
            _route.send(DetailRoute.GoToWebView(url))
        }
    }

    sealed class DetailRoute {
        object GoBack : DetailRoute()
        class GoToWebView(val url: String) : DetailRoute()
    }
}