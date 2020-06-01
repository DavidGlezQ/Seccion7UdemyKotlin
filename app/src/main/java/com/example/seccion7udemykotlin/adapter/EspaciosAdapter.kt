package com.example.seccion7udemykotlin.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.listener.RecyclerFlightListener
import com.example.seccion7udemykotlin.models.Espacios
import com.example.seccion7udemykotlin.others.inflate
import com.example.seccion7udemykotlin.others.loadByResource
import kotlinx.android.synthetic.main.recycler_espacios.view.*

class FlightAdapter(private val espacio: List<Espacios>, private val listener: RecyclerFlightListener)
    : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_espacios))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(espacio[position], listener)

    override fun getItemCount() = espacio.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Espacios, listener: RecyclerFlightListener) = with(itemView) {
            textViewCityName.text = flight.name
            imageViewBg.loadByResource(flight.imgResource)
            // Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}