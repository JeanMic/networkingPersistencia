package com.jeanandroid.networkingpersistencia.rom

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jeanandroid.networkingpersistencia.R
import com.jeanandroid.networkingpersistencia.entidadeFakeAPI
import kotlinx.android.synthetic.main.recyclerview.view.*

class adapterForDB(private val arraydeEntidades: ArrayList<entidadeFakeAPI>) : RecyclerView.Adapter<adapterForDB.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(arraydeEntidades[position])
    }

    override fun getItemCount(): Int = arraydeEntidades.count()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(android: entidadeFakeAPI) {
            itemView.nome.text = android.name
            itemView.email.text = android.email
            itemView.body.text = android.body
        }
    }
}