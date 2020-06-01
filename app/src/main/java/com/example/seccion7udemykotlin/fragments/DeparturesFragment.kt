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
import com.example.seccion7udemykotlin.adapters.SpaceAdapter
import com.example.seccion7udemykotlin.listener.RecyclerSpaceListener
import com.example.seccion7udemykotlin.models.Spaces
import com.example.seccion7udemykotlin.others.toast
import kotlinx.android.synthetic.main.fragment_departures.view.*

class DeparturesFragment : Fragment() {

    private val list: ArrayList<Spaces> by lazy { getSpace() }
    private lateinit var recycler: RecyclerView
    private lateinit var adapter: SpaceAdapter
    private val layoutManager by lazy { LinearLayoutManager(context) }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_departures, container, false)
        recycler = rootView.recyclerView as RecyclerView
        setRecyclerView()
        return rootView
    }

    private fun setRecyclerView(){
        recycler.setHasFixedSize(true)
        recycler.itemAnimator = DefaultItemAnimator()
        recycler.layoutManager = layoutManager
        adapter = (SpaceAdapter(list, object: RecyclerSpaceListener{
            override fun onClick(space: Spaces, position: Int) {
                activity?.toast("The ${space.name}!")
            }

            override fun onDelete(space: Spaces, position: Int) {
                list.remove(space)
                adapter.notifyItemRemoved(position)
                activity?.toast("${space.name} has removed of the gallery!")
            }
        }))
        recycler.adapter = adapter
    }

    private fun getSpace(): ArrayList<Spaces>{
        return object: ArrayList<Spaces>(){
            init {
                add(Spaces(1, "Andromeda Galaxy", R.drawable.andromeda_galaxy))
                add(Spaces(2, "Astronomy", R.drawable.astronomy))
                add(Spaces(3,"Astronaut", R.drawable.astronaut))
                add(Spaces(4,"Constellation", R.drawable.constellation))
                add(Spaces(5,"Earth", R.drawable.earth))
                add(Spaces(6,"Lagoon Nebula", R.drawable.lagoon_nebula))
                add(Spaces(7,"Solar", R.drawable.solar))
                add(Spaces(8,"Night", R.drawable.night))
                add(Spaces(9,"Milky Way", R.drawable.milky_way))
                add(Spaces(10,"Stars", R.drawable.stars))
                add(Spaces(11,"Lunar Eclipse", R.drawable.lunar_eclipse))
            }
        }
    }
}
