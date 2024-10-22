package com.example.finalproject.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.models.Entity

class EntityAdapter(private val onItemClick: (Entity) -> Unit) :
    ListAdapter<Entity, EntityAdapter.EntityViewHolder>(EntityDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = getItem(position)
        holder.bind(entity)
        holder.itemView.setOnClickListener {
            onItemClick(entity)
        }
    }

    class EntityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val nameTextView: TextView = itemView.findViewById(R.id.entity_name)
        private val architectTextView: TextView = itemView.findViewById(R.id.entity_architect)
        private val locationTextView: TextView = itemView.findViewById(R.id.entity_location)
        private val yearTextView: TextView = itemView.findViewById(R.id.entity_year)
        private val styleTextView: TextView = itemView.findViewById(R.id.entity_style)
        private val heightTextView: TextView = itemView.findViewById(R.id.entity_height)
        private val descriptionTextView: TextView = itemView.findViewById(R.id.entity_description)

        // Bind entity data to the views
        fun bind(entity: Entity) {
            nameTextView.text = entity.name
            architectTextView.text = entity.architect
            locationTextView.text = entity.location
            yearTextView.text = entity.year.toString()
            styleTextView.text = entity.style
            heightTextView.text = entity.height.toString()
            descriptionTextView.text = entity.description
        }
    }
}

// DiffUtil for optimizing RecyclerView updates
class EntityDiffCallback : DiffUtil.ItemCallback<Entity>() {
    override fun areItemsTheSame(oldItem: Entity, newItem: Entity): Boolean {
        return oldItem.id == newItem.id  // Assuming entity has a unique 'id' field
    }

    override fun areContentsTheSame(oldItem: Entity, newItem: Entity): Boolean {
        return oldItem == newItem  // Compare entire content of the items
    }
}
