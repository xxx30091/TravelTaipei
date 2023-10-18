package com.example.traveltaipei

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.traveltaipei.utils.CurrentFragmentType

class MainViewModel : ViewModel() {

    val currentFragmentType = MutableLiveData<CurrentFragmentType>()

}