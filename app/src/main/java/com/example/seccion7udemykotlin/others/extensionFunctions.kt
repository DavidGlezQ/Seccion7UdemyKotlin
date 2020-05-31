package com.example.seccion7udemykotlin.others

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso

//ExtensionFunction para Toast
fun Activity.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, message, duration).show()
fun Activity.toast(resourceId: Int, duration: Int = Toast.LENGTH_SHORT) = Toast.makeText(this, resourceId, duration).show()

//PeronAdapter
fun ViewGroup.inflate(layoutId: Int) = LayoutInflater.from(context).inflate(layoutId, this, false)!!

//Load By URL
fun ImageView.loadByURL(url: String) = Picasso.with(context).load(url).into(this)

fun ImageView.loadByResource(resource: Int) = Picasso.with(context).load(resource).fit().into(this)

//Go to Activity
inline fun <reified T : Activity>Activity.goToActivity(noinline init: Intent.() -> Unit = {}){
    val intent = Intent(this, T::class.java)
    intent.init()
    startActivity(intent)
}