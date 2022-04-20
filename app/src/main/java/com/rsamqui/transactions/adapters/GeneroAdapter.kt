package com.rsamqui.transactions.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rsamqui.transactions.R
import com.rsamqui.transactions.entities.Genero

class GeneroAdapter(val compra:List<Genero>):RecyclerView.Adapter<GeneroAdapter.GeneroHolder>()  {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): GeneroHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_list, null, false)
        return GeneroHolder(view)
    }

    override fun onBindViewHolder(holder: GeneroHolder, position: Int) {
        val current =compra[position]
        holder.tvTitulo.text = current.nombre
        holder.tvSubtitulo.text ="ID = ${ current.idGenero.toString()}"
    }

    override fun getItemCount(): Int = compra.size

    class GeneroHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.item_title)
        val tvSubtitulo: TextView = itemView.findViewById(R.id.item_sub)

    }

}