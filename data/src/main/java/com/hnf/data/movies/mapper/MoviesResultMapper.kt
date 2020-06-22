package com.hnf.data.movies.mapper

import com.hnf.data.movies.repository.source.network.result.MovieResult
import com.hnf.data.movies.repository.source.network.result.MoviesResult
import com.hnf.domain.movies.model.Movie
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesResultMapper, v 0.1 22/06/20 04.00 by Hanif Ibrahim
 */
class MoviesResultMapper @Inject constructor() {

    fun transform(movieResults: MoviesResult): List<Movie> =
        movieResults.results.map { it.toMovies() }
    
    private fun MovieResult.toMovies() = Movie(
        title = this.title,
        overview = this.overview
    )
}