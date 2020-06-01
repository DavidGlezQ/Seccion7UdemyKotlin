package com.example.seccion7udemykotlin.listener

import com.example.seccion7udemykotlin.models.Spaces

interface RecyclerSpaceListener{
    fun onClick(space: Spaces, position: Int)
    fun onDelete(space: Spaces, position: Int)
}