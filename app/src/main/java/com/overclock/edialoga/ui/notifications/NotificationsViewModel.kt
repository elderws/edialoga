package com.overclock.edialoga.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _grupos = MutableLiveData<List<String>>() // Supondo que seja uma lista de Strings
    val grupos: LiveData<List<String>> = _grupos

    init {
        // Inicialize a lista de grupos com dados de exemplo ou faça uma chamada de API
        _grupos.value = listOf("Grupo 1", "Grupo 2", "Grupo 3")
    }
}