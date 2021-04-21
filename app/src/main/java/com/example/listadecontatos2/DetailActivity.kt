package com.example.listadecontatos2

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.contact_detail.*

class DetailActivity :AppCompatActivity(){
    private var contact: Contact? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contact_detail)

        initToolbar()
        getExtras()
        bindViews()
    }

    //Insere a toolbar
    private fun initToolbar(){
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Recebe os dados do contato da MainActivity
    private fun getExtras(){
        contact = intent.getParcelableExtra(EXTRA_CONTACT)
    }

    //Altera os dados da activity contact_detail com os dados do contato clicado na Main Activity
    private fun bindViews(){
        findViewById<TextView>(R.id.tv_name).text = contact?.name
        findViewById<TextView>(R.id.tv_phone).text = contact?.phone
    }

    companion object{
        const val EXTRA_CONTACT: String = "EXTRA_CONTACT"
    }

    //Ativa a função do botão voltar da Toolbar
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}