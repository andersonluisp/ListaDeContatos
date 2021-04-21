package com.example.listadecontatos2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private val rvList: RecyclerView by lazy {
        findViewById<RecyclerView>(R.id.rv_list)
    }
    private val adapter = ContactAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_menu)

        initDrawer()
        bindViews()
        updateList()
        clickDrawerMenuItems()

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
    }

    private fun updateList(){
        adapter.updateList(
            arrayListOf(
                Contact(
                    "Igor Ferrani",
                    "(00) 0000-0000",
                    "img.png"
                ),
                Contact(
                    "Igor Ferrani",
                    "(00) 0000-0000",
                    "img.png"
                )
            )
        )
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
}