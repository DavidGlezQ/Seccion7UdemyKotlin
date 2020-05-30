package com.example.seccion7udemykotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.fragments.ArrivalsFragment
import com.example.seccion7udemykotlin.fragments.DeparturesFragment
import com.example.seccion7udemykotlin.fragments.HomeFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //toolbar
        setSupportActionBar(findViewById(R.id.toolbar))
        setNavDrawer()
        fragmentsTrasnsactions(HomeFragment())
        navView.menu.getItem(0).isChecked = true
    }

    //Interfaz que nos permite controlar las opciones de nuestro menu.
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.nav_home -> fragmentsTrasnsactions(HomeFragment())
            R.id.nav_arrivals -> fragmentsTrasnsactions(ArrivalsFragment())
            R.id.nav_departures -> fragmentsTrasnsactions(DeparturesFragment())
        }
        return true
    }

    //Metodo para agreagr el icono y nos poermite abrir y cerrar el menu lateral.
    private fun setNavDrawer(){
        val toggle = ActionBarDrawerToggle(this, DrawerLayout, toolbar as Toolbar?, R.string.open_drawer, R.string.close_drawer)
        toggle.isDrawerIndicatorEnabled = true
        DrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)
    }

    //Fragments cambio
    private fun fragmentsTrasnsactions(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()
    }
}
