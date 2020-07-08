package com.example.room.ui.list

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.room.R
import com.example.room.model.Deudor
import kotlinx.android.synthetic.main.item_deudor.view.*

class DeudoresRVAdapter (
    var context: Context,
    var deudoresList: ArrayList<Deudor>
) : RecyclerView.Adapter<DeudoresRVAdapter.DeudoresViewHolder>(){
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DeudoresRVAdapter.DeudoresViewHolder {
        var itemView = LayoutInflater.from(context).inflate(R.layout.item_deudor, parent, false)
        return DeudoresViewHolder(itemView, context)

    }

    override fun getItemCount(): Int = deudoresList.size

    override fun onBindViewHolder(holder: DeudoresRVAdapter.DeudoresViewHolder, position: Int) {
        val deudor : Deudor = deudoresList[position]
        holder.bindDeudor(deudor)
    }
    class DeudoresViewHolder(
        itemView: View,
        context: Context
    ) : RecyclerView.ViewHolder(itemView){

        fun bindDeudor(deudor: Deudor){
            itemView.tv_nombre.text = deudor.nombre
            itemView.tv_deuda.text = deudor.cantidad.toString()
        }

    }
}