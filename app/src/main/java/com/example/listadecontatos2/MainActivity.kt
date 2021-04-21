package com.example.listadecontatos2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global.putString
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.appcompat.widget.Toolbar
import androidx.core.content.edit
import com.example.listadecontatos2.DetailActivity.Companion.EXTRA_CONTACT
import com.google.android.material.navigation.NavigationView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity(), ClickItemContactListener {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        clickDrawerMenuItems()
        fetchListContact()
        bindViews()
    }

    private fun fetchListContact(){
        val list = arrayListOf(
            Contact(
                "Igor Ferrani",
                "(00) 0000-0000",
                "img.png"
            ),
            Contact(
                "Jose Almeida",
                "(99) 9999-9999",
                "img.png"
            )
        )
        getInstanceSharedPreferences().edit(){
            val json =  Gson().toJson(list)
            putString("contacts", json)
            commit()
        }
    }

    private fun getInstanceSharedPreferences(): SharedPreferences {
        return getSharedPreferences("com.example.listadecontatos2.PREFERENCES", Context.MODE_PRIVATE)
    }

    private fun initDrawer(){
        val drawerLayout = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawerLayout,toolbar, R.string.open_drawer, R.string.close_drawer)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun bindViews(){
        rvList.adapter = adapter
        rvList.layoutManager = LinearLayoutManager(this)
        updateList()
    }

    private fun getListContacts(): List<Contact>{
        val list = getInstanceSharedPreferences().getString("contacts", "[]")
        val turnsType = object : TypeToken<List<Contact>>() {}.type
        return Gson().fromJson(list, turnsType)
    }

    private fun updateList(){
        val list = getListContacts()
        adapter.updateList(list)
    }

    private fun showtoast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Cria o menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.item_menu_1 -> {
                showtoast("Exibindo item de menu 1")
                return true
            }
            R.id.item_menu_2 -> {
                showtoast("Exibindo item de menu 2")
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun clickDrawerMenuItems(){
        val navview = findViewById<View>(R.id.nav_view) as NavigationView
        navview.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.item_menudrawer_1 -> showtoast("Item 1 Menu Drawer")
                R.id.item_menudrawer_2 -> showtoast("Item 2 Menu Drawer")
            }
            true
        }
    }

    override fun clickItemContact(contact: Contact) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra(EXTRA_CONTACT, contact)
        startActivity(intent)
    }
}