package com.example.seccion7udemykotlin.adapters

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.seccion7udemykotlin.R
import com.example.seccion7udemykotlin.listener.RecyclerSpaceListener
import com.example.seccion7udemykotlin.models.Spaces
import com.example.seccion7udemykotlin.others.inflate
import com.example.seccion7udemykotlin.others.loadByResource
import kotlinx.android.synthetic.main.recycler_space.view.*


class SpaceAdapter(private val space: List<Spaces>, private val listener: RecyclerSpaceListener)
    : RecyclerView.Adapter<SpaceAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent.inflate(R.layout.recycler_space))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(space[position], listener)

    override fun getItemCount() = space.size

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(spaces: Spaces, listener: RecyclerSpaceListener) = with(itemView){
            textViewSpaceName.text = spaces.name
            imageViewBg.loadByResource(spaces.imgResource)
            //Click events
            setOnClickListener{ listener.onClick(spaces, adapterPosition) }
            bottomDelete.setOnClickListener{ listener.onDelete(spaces, adapterPosition) }
        }
    }
}