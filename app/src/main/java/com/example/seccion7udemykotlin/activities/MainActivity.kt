package com.example.seccion7udemykotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.fragments.ArrivalsFragment
import com.example.seccion7udemykotlin.fragments.DeparturesFragment
import com.example.seccion7udemykotlin.fragments.HomeFragment
import com.example.seccion7udemykotlin.others.toast
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        setNavDrawer()
        setUserHeaderInformation()
        //Controlar el cambio de lso fragments al cambiar la orientacion de la app
        if (savedInstanceState == null) {
            fragmentsTransactions(HomeFragment())
            navView.menu.getItem(0).isChecked = true
        }
    }


    //Usuario y email en el banner
    private fun setUserHeaderInformation() {
        val name = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewName)
        val email = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewEmail)

        name?.let { name.text = getString(R.string.user_name) }
        email?.let { email.text = getString(R.string.user_email) }
    }

    //Metodo para agreagr el icono y nos poermite abrir y cerrar el menu lateral.
    private fun setNavDrawer(){
        val toggle = ActionBarDrawerToggle(this, DrawerLayout, toolbar as Toolbar?, R.string.open_drawer, R.string.close_drawer)
        toggle.isDrawerIndicatorEnabled = true
        DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    //Toast en las ultimas opciones.
    private fun showMessageNavItemSelectedById(id: Int) {
        when (id) {
            R.id.nav_profile -> toast("Profile")
            R.id.nav_settings -> toast("Settings")
        }
    }

    //Cmabio entre los fragments
    private fun fragmentsTransactions(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    //Este metodo carga los items a sus respectivos fragments.
    private fun loadFragmentById(id: Int) {
        when (id) {
            R.id.nav_home -> fragmentsTransactions(HomeFragment())
            R.id.nav_departures -> fragmentsTransactions(DeparturesFragment())
            R.id.nav_arrivals -> fragmentsTransactions(ArrivalsFragment())
        }
    }

    //Interfaz que nos permite controlar las opciones de nuestro menu.
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        showMessageNavItemSelectedById(item.itemId)
        loadFragmentById(item.itemId)
        DrawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    //Este metodo lo que hace es que si esta abierto el menu y se preciona el boton back solo se cierre el menu y no la app.
    override fun onBackPressed() {
        if (DrawerLayout.isDrawerOpen(GravityCompat.START)) {
            DrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
