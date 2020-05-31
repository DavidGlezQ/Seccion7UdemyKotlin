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
        if(savedInstanceState == null) {
            fragmentsTrasnsactions(HomeFragment())
            navView.menu.getItem(0).isChecked = true
        }
    }

    //Metodo para agreagr el icono y nos poermite abrir y cerrar el menu lateral.
    private fun setNavDrawer(){
        val toggle = ActionBarDrawerToggle(this, DrawerLayout, toolbar as Toolbar?, R.string.open_drawer, R.string.close_drawer)
        toggle.isDrawerIndicatorEnabled = true
        DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    //Cambio entre fragments.
    private fun fragmentsTrasnsactions(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }

    //Funcion para hacer el cambio de los fragments.
    private fun loadFragmentById(id: Int){
        when (id){
            R.id.nav_home -> fragmentsTrasnsactions(HomeFragment())
            R.id.nav_arrivals -> fragmentsTrasnsactions(ArrivalsFragment())
            R.id.nav_departures -> fragmentsTrasnsactions(DeparturesFragment())
        }
    }

    //Funcion para mostrar los mensajes (toast con KAT), de las dos ultimas opciones.
    private fun showMessageNavItemSelectedById(id: Int){
        when (id){
            R.id.nav_profile -> toast("profile")
            R.id.nav_settings -> toast("Settings")
        }
    }

    //Funcion para mostrar el usuario y el email del usuario.
    private fun setUserHeaderInformation(){
        val name = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewName)
        val email = navView.getHeaderView(0).findViewById<TextView>(R.id.textViewEmail)

        name?.let { name.text = getString(R.string.user_name) }
        email?.let { email.text = getString(R.string.user_email) }
    }

    //Interfaz que nos permite controlar las opciones de nuestro menu.
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        showMessageNavItemSelectedById(item.itemId)
        loadFragmentById(item.itemId)
        DrawerLayout.closeDrawer(GravityCompat.START) //Con esta linea hacemos que cada que seleccionemos una opcion se cierre el menu.
        return true
    }

    //Funcion para que al presionar el boton de back estando el NavigationView abierto solo cierre esa vista y no la app.
    override fun onBackPressed(){
        if (DrawerLayout.isDrawerOpen(GravityCompat.START)) {
            DrawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
