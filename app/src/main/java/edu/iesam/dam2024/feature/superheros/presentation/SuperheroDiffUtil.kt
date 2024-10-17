package edu.iesam.dam2024.feature.superheros.presentation

import androidx.recyclerview.widget.DiffUtil
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroDiffUtil : DiffUtil.ItemCallback<Superhero>() {
    override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return  oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return oldItem == newItem
    }
}