package com.hnf.domain.movies

import com.hnf.domain.movies.model.Movie
import io.reactivex.Observable


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesRepository, v 0.1 22/06/20 03.46 by Hanif Ibrahim
 */
interface MoviesRepository {

    fun getNowPlaying(): Observable<List<Movie>>
}