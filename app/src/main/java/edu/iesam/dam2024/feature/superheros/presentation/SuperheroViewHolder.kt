package edu.iesam.dam2024.feature.superheros.presentation
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.dam2024.app.extensions.loadUrl
import edu.iesam.dam2024.databinding.ViewSuperheroItemBinding
import edu.iesam.dam2024.feature.superheros.domain.Superhero

class SuperheroViewHolder(val view: View, val navigateToDetail: (String) -> Unit) : RecyclerView.ViewHolder(view) {

    private lateinit var binding: ViewSuperheroItemBinding

    fun bind(model: Superhero) {
        binding = ViewSuperheroItemBinding.bind(view)
        binding.apply {
            img.loadUrl(model.images.md)
            name.text = model.name
        }
        // Manejar clic para navegar
        view.setOnClickListener {
            navigateToDetail(model.id)  // Pasar el id del superhéroe
        }
    }
}
