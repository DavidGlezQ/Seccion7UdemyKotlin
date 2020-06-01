package com.example.seccion7udemykotlin.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.listener.RecyclerFlightListener
import com.example.seccion7udemykotlin.models.Flight
import com.example.seccion7udemykotlin.others.inflate
import com.example.seccion7udemykotlin.others.loadByResource
import kotlinx.android.synthetic.main.recycler_espacios.view.*

class FlightAdapter(private val flights: List<Flight>, private val listener: RecyclerFlightListener)
    : RecyclerView.Adapter<FlightAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_espacios))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(flights[position], listener)

    override fun getItemCount() = flights.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(flight: Flight, listener: RecyclerFlightListener) = with(itemView) {
            textViewCityName.text = flight.city
            imageViewBg.loadByResource(flight.imgResource)
            // Clicks Events
            setOnClickListener { listener.onClick(flight, adapterPosition) }
            buttonDelete.setOnClickListener { listener.onDelete(flight, adapterPosition) }
        }
    }
}