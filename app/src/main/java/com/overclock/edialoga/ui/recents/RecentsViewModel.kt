package com.overclock.edialoga.ui.recents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is recents Fragment"
    }
    val text: LiveData<String> = _text
}