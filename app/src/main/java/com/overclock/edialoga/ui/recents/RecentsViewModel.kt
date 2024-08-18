package com.overclock.edialoga.ui.recents

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecentsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Todos os Chats Recents"
    }
    val text: LiveData<String> = _text
}