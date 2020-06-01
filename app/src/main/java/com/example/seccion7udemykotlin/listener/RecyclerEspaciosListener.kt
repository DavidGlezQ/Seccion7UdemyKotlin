package com.example.seccion7udemykotlin.listener

import com.example.seccion7udemykotlin.models.Espacios

interface RecyclerFlightListener {
    fun onClick(flight: Espacios, position: Int)
    fun onDelete(flight: Espacios, position: Int)
}