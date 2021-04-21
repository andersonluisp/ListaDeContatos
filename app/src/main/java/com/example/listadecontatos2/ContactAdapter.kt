package com.example.listadecontatos2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Text

class ContactAdapter(var listener: ClickItemContactListener) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {

    //<Contact> é a classe modelo dos itens da lista
    private val list: MutableList<Contact> = mutableListOf()

    // Responsável por criar cada item visual da nossa tela
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.contact_item, parent, false)
        return ContactAdapterViewHolder(view, list, listener)
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

    fun updateList(list: List<Contact>){
        this.list.clear()
        this.list.addAll(list)
        notifyDataSetChanged()  //  Notifica o adapter que a lista que precisa fazer a renderização foi modificada
    }

    //Gerencia cada item da lista
    class ContactAdapterViewHolder(itemview: View, var list:List<Contact>, var listener: ClickItemContactListener) : RecyclerView.ViewHolder(itemview){
        private val tvName: TextView = itemView.findViewById(R.id.tv_name)
        private val tvPhone: TextView = itemView.findViewById(R.id.tv_phone)
        private val ivPhotoraph: ImageView = itemView.findViewById(R.id.iv_photograph)

        init {
            itemview.setOnClickListener{
                listener.clickItemContact(list[adapterPosition])
            }
        }

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvPhone.text = contact.phone
        }
    }
}