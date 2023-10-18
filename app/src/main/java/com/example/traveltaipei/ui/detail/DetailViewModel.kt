package com.example.traveltaipei.ui.detail

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import okhttp3.Route

class DetailViewModel : ViewModel() {

    private val _route = Channel<DetailRoute>()
    val route = _route.receiveAsFlow()

    init {
        Log.i("Arthur", "viewModel = ${this.hashCode()}")
    }

    fun goBack() {
        viewModelScope.launch {
            _route.send(DetailRoute.GoBack)
        }
    }

    sealed class DetailRoute {
        object GoBack : DetailRoute()
    }

}