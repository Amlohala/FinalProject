package com.example.finalproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.R
import com.example.finalproject.models.Entity

class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.EntityViewHolder>() {

    private var entities: List<Entity> = listOf()

    fun setData(entities: List<Entity>) {
        this.entities = entities
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EntityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_entity, parent, false)
        return EntityViewHolder(view)
    }

    override fun onBindViewHolder(holder: EntityViewHolder, position: Int) {
        val entity = entities[position]
        holder.bind(entity)
    }

    override fun getItemCount(): Int {
        return entities.size
    }

    class EntityViewHolder(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {
        private val entityName: android.widget.TextView = itemView.findViewById(R.id.entity_name)
        private val entityDescription: android.widget.TextView = itemView.findViewById(R.id.entity_description)

        fun bind(entity: Entity) {
            entityName.text = entity.name // assuming Entity has a 'name' field
            entityDescription.text = entity.description // assuming Entity has a 'description' field
        }
    }
}
