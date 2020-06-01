package com.example.seccion7udemykotlin.listener

import com.example.seccion7udemykotlin.models.Flight

interface RecyclerFlightListener {
    fun onClick(flight: Flight, position: Int)
    fun onDelete(flight: Flight, position: Int)
}