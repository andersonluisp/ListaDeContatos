package com.example.listadecontatos2

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //<Contact> é a classe modelo dos itens da lista
    private val list: MutableList<Contact> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        TODO("Not yet implemented")
    }

    //Rodar em cada item do Array, obter o valor em cada item e preencher na tela.
    // Vai popular o item no recycler view
    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        //Precisa passar por todos os itens gerenciaods pela class ContactAdapterViewHolder
        holder.bind(list[position])
    }

    //Quantidade de itens que existe na lista que estamos passando
    override fun getItemCount(): Int {
        return list.size
    }

    //Gerencia cada item da lista
    class ContactAdapterViewHolder(itemview: View) : RecyclerView.ViewHolder(itemview){


        fun bind(contact: Contact) {

        }
    }
}