package com.overclock.edialoga.ui.notifications

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import java.io.IOException

class NotificationsViewModel : ViewModel() {

    private val _grupos = MutableLiveData<List<GrupoAdapter.Grupo>>()
    val grupos: LiveData<List<GrupoAdapter.Grupo>> = _grupos

    init {
        fetchGroupsFromApi()
    }

    private fun fetchGroupsFromApi() {
        val client = OkHttpClient()
        val request = Request.Builder()
            .url("https://jsonplaceholder.typicode.com/posts?_limit=5")
            .build()

        Thread {
            try {
                val response = client.newCall(request).execute()
                if (response.isSuccessful) {
                    response.body?.use { responseBody ->
                        val responseString = responseBody.string()
                        val gruposResponse = parseJsonToGrupos(responseString)
                        _grupos.postValue(gruposResponse)
                    }
                } else {
                    Log.e("API Error", "Response not successful")
                }
            } catch (e: IOException) {
                Log.e("API Failure", e.message ?: "Unknown error")
            }
        }.start()
    }

    private fun parseJsonToGrupos(jsonString: String?): List<GrupoAdapter.Grupo> {
        val grupos = mutableListOf<GrupoAdapter.Grupo>()
        if (jsonString != null) {
            val jsonArray = JSONArray(jsonString)
            for (i in 0 until jsonArray.length()) {
                val jsonObject = jsonArray.getJSONObject(i)
                val grupo = GrupoAdapter.Grupo(
                    title = jsonObject.getString("title")
                )
                grupos.add(grupo)
            }
        }
        return grupos
    }
}