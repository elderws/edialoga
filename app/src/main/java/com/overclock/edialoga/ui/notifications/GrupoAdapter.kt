package com.overclock.edialoga.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.overclock.edialoga.R

class GrupoAdapter(private val grupos: List<Grupo>) : RecyclerView.Adapter<GrupoAdapter.GrupoViewHolder>() {

    class GrupoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val avatar: ImageView = itemView.findViewById(R.id.imageAvatar)
        val nomeGrupo: TextView = itemView.findViewById(R.id.textNomeGrupo)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grupo, parent, false)
        return GrupoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GrupoViewHolder, position: Int) {
        val grupo = grupos[position]
        holder.avatar.setImageResource(android.R.mipmap.sym_def_app_icon) // Imagem padrão
        holder.nomeGrupo.text = grupo.nome
    }

    override fun getItemCount(): Int {
        return grupos.size
    }
}