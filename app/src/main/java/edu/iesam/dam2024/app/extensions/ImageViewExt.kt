package edu.iesam.dam2024.app.extensions
import com.bumptech.glide.Glide
import android.widget.ImageView

//asi se le pueden agregar funciones a una clase ya existente
    fun ImageView.loadUrl(url:String){
        Glide.with(this).load(url).into(this)
    }
