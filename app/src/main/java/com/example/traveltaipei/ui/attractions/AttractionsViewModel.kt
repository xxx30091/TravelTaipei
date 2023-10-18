package com.example.traveltaipei.ui.attractions

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.traveltaipei.MyApplication.Companion.tripRepository
import com.example.traveltaipei.network.model.AttractionItem
import com.example.traveltaipei.network.model.Language
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

class AttractionsViewModel : ViewModel() {

    private val _lang = MutableLiveData<String>()
    val lang: LiveData<String>
        get() = _lang

    val allLangList = arrayListOf(
        Language("zh-tw", "正體中文"),
        Language("zh-cn", "简体中文"),
        Language("en", "English"),
        Language("ja", "ja"),
        Language("ko", "ko"),
        Language("es", "es"),
        Language("id", "id"), // api 不接受這個語言，會回400
        Language("th", "th"),
        Language("vi", "vi")
    )

    private var _attractionsInfo = MutableLiveData<List<AttractionItem>?>()
    val attractionsInfo: LiveData<List<AttractionItem>?>
        get() = _attractionsInfo

    init {
        _lang.postValue("zh-tw")
        getAttractionsAll("zh-tw")
    }

    private val _route = Channel<NavRoute>()
    val route = _route.receiveAsFlow()

    fun goToDetail(attraction: AttractionItem) {
        viewModelScope.launch {
            _route.send(NavRoute.GoToDetail(attraction))
        }
    }

    fun showLanguageList() {
        viewModelScope.launch {
            _route.send(NavRoute.ShowLanguageList)
        }
    }

    fun changeLanguage(lang: String) {
        viewModelScope.launch {
            _route.send(NavRoute.ChangeLanguage(lang))
            getAttractionsAll(lang)
            _lang.postValue(lang)
        }
    }

    private fun getAttractionsAll(lang: String) {
        viewModelScope.launch {
            val result = tripRepository.getAttractionsAll(lang)
            val resultData = result.code()

//            Log.i("Arthur", result.toString())
//            Log.i("Arthur", resultData.toString())
//            Log.i("Arthur", result.body().toString())

            when (result.code()) {
                200 -> {
                    _attractionsInfo.postValue(result.body()?.data)
                }
                else -> {
                    _route.send(NavRoute.Toast("Error code: ${result.code()}"))
                }
            }

        }
    }

    sealed class NavRoute {
        class GoToDetail(val attraction: AttractionItem) : NavRoute()
        object ShowLanguageList : NavRoute()
        class ChangeLanguage(val lang: String) : NavRoute()
        class Toast(val msg: String) : NavRoute()
    }

}