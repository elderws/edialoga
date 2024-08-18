package com.overclock.edialoga.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.overclock.edialoga.R

class NotificationsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewGrupos)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val grupos = listOf(
            Grupo("Administrativo"),
            Grupo("Suporte TI"),
            Grupo("Financeiro"),
            Grupo("Contabilidade"),
            Grupo("Sistema Novo")
        )

        val adapter = GrupoAdapter(grupos)
        recyclerView.adapter = adapter
    }
}