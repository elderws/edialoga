package com.overclock.edialoga.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.overclock.edialoga.R

class GrupoAdapter(private val grupos: List<String>) : RecyclerView.Adapter<GrupoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_grupo, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(grupos[position])
    }

    override fun getItemCount(): Int = grupos.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textNomeGrupo: TextView = itemView.findViewById(R.id.textNomeGrupo)

        fun bind(grupo: String) {
            textNomeGrupo.text = grupo
        }
    }
}