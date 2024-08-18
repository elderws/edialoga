package com.overclock.edialoga.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.overclock.edialoga.R

class GrupoAdapter(
    private val grupos: List<Grupo>,
    private val onItemClick: (Grupo) -> Unit
) : RecyclerView.Adapter<GrupoAdapter.GrupoViewHolder>() {

    data class Grupo(val title: String)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GrupoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_grupo, parent, false)
        return GrupoViewHolder(view)
    }

    override fun onBindViewHolder(holder: GrupoViewHolder, position: Int) {
        val grupo = grupos[position]
        holder.bind(grupo)
        holder.itemView.setOnClickListener { onItemClick(grupo) }
    }

    override fun getItemCount(): Int = grupos.size

    class GrupoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.title)
        private val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(grupo: Grupo) {
            title.text = grupo.title
            image.setImageResource(android.R.drawable.ic_menu_myplaces)
        }
    }
}