package edu.iesam.dam2024.feature.superheros.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import edu.iesam.dam2024.R
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroAdapter(private val navigateToDetail: (String) -> Unit) : ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.view_superhero_item, parent, false)
        return SuperheroViewHolder(view, navigateToDetail)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        holder.bind(currentList[position])
    }
}
