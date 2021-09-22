package com.smendon.android.dynamicdashboard.components.banners

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BannersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This fragment displays a Banner"
    }
    val text: LiveData<String> = _text
}