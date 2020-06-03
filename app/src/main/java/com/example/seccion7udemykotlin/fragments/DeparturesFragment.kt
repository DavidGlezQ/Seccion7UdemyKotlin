package com.example.seccion7udemykotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.adapter.FlightAdapter
import com.example.seccion7udemykotlin.listener.RecyclerFlightListener
import com.example.seccion7udemykotlin.models.Espacios
import com.example.seccion7udemykotlin.others.toast
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Espacios> by lazy { getFlights() }

    private lateinit var recycler: RecyclerView
    private lateinit var adapter: FlightAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        activity?.setTitle(R.string.departures_fragment_title)
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()
        return rootView
    }

    private fun setRecyclerView() {
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (FlightAdapter(list, object : RecyclerFlightListener {
            override fun onClick(espacio: Espacios, position: Int) {
                activity?.toast("The ${espacio.name}!")
            }

            override fun onDelete(espacio: Espacios, position: Int) {
                list.remove(espacio)
                adapter.notifyItemRemoved(position)
                activity?.toast("${espacio.name} has been removed!")
            }
        }))
        recycler.adapter = adapter
    }

    private fun getFlights(): ArrayList<Espacios> {
        return object : ArrayList<Espacios>() {
            init {
                add(Espacios(1, "Lunar Eclipse", R.drawable.lunar_eclipse))
                add(Espacios(2, "Constellation", R.drawable.constellation))
                add(Espacios(3, "Stars", R.drawable.stars))
                add(Espacios(4, "Milky Way", R.drawable.milky_way))
                add(Espacios(5, "Lagoon Nebula", R.drawable.lagoon_nebula))
                add(Espacios(6, "Earth", R.drawable.earth))
                add(Espacios(7, "Andromeda Galaxy", R.drawable.andromeda_galaxy))
                add(Espacios(8, "Astronaut", R.drawable.astronaut))
                add(Espacios(9, "Astronomy", R.drawable.astronomy))
                add(Espacios(9, "Solar System", R.drawable.solar_system))
                add(Espacios(9, "Night", R.drawable.night))
            }
        }
    }
}
