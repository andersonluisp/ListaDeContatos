package com.example.listadecontatos2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter : RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //<Contact> é a classe modelo dos itens da lista
    private val list: MutableList<Contact> = mutableListOf()

    // Responsável por criar cada item visual da nossa tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view)
    }

    // Rodar em cada item do Array, obter o valor em cada item e preencher na tela.
    // Vai popular o item no recycler view com os itens do onCreateViewHolder
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