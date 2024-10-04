package edu.iesam.dam2024.feature.movies.presentation


import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import edu.iesam.dam2024.R
import edu.iesam.dam2024.app.domain.ErrorApp
import edu.iesam.dam2024.feature.movies.domain.Movie
import edu.iesam.dam2024.feature.superheros.presentation.SuperherosActivity

class MoviesActivity : AppCompatActivity() {

    private lateinit var movieFactory: MovieFactory
    private lateinit var viewModel: MoviesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        movieFactory = MovieFactory(this)
        viewModel = movieFactory.buildViewModel()

        val movieObserver = Observer<MoviesViewModel.UiState>{uiState->
            uiState.movies?.let {
                bindData(it)
            }
            uiState.errorApp?.let{
                //pinto error
            }
            if(uiState.isLoading){
                //muestro el cargado...
            }else{
                // oculto el cargado...
            }

        }
        viewModel.uiState.observe(this,movieObserver)



    }

     fun bindData(movies: List<Movie>) {

        blockMovie(movies[0], R.id.movie_id_1, R.id.movie_title_1, R.id.movie_layout_1)
        blockMovie(movies[1], R.id.movie_id_2, R.id.movie_title_2, R.id.movie_layout_2)
        blockMovie(movies[2], R.id.movie_id_3, R.id.movie_title_3, R.id.movie_layout_3)
        blockMovie(movies[3], R.id.movie_id_4, R.id.movie_title_4, R.id.movie_layout_4)
        var goHero:String= getString(R.string.goSuperheros)
        findViewById<TextView>(R.id.goHero).text= goHero
        findViewById<LinearLayout>(R.id.movie_layout_5).setOnClickListener {
            navigateToSuperherosList()
        }

    }

    private fun blockMovie(movie: Movie, nId: Int, nTitle: Int, nLayout: Int) {
        findViewById<TextView>(nId).text = movie.id
        findViewById<TextView>(nTitle).text = movie.title
        findViewById<LinearLayout>(nLayout).setOnClickListener {
            navigateToMovieDetail(movie.id)
        }
    }
private fun funshowError(error: ErrorApp){
    when(error){
        ErrorApp.DataErrorApp -> TODO()
        ErrorApp.InternetErrorApp -> TODO()
        ErrorApp.ServerErrorApp -> TODO()
        ErrorApp.UnknowErrorApp -> TODO()
    }
}

    private fun navigateToMovieDetail(movieId: String) {
        startActivity(MovieDetailActivity.getIntent(this,movieId))
    }
    private fun navigateToSuperherosList() {
        startActivity(SuperherosActivity.getIntent(this))
    }
    companion object {
        fun getIntent(context: Context): Intent {
            val intent = Intent(context, MoviesActivity::class.java)
            return intent
        }
    }
}
