package com.hnf.data.movies.repository.source.network

import com.hnf.data.movies.repository.MoviesEntityData
import com.hnf.data.movies.repository.source.network.result.MovieResult
import com.hnf.data.movies.repository.source.network.result.MoviesResult
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NetworkMoviesEntityData, v 0.1 22/06/20 02.09 by Hanif Ibrahim
 */
class NetworkMoviesEntityData @Inject constructor(
    private val moviesApi: MoviesApi
) : MoviesEntityData {

    override fun nowPlaying(): Observable<MoviesResult> = moviesApi.nowPlaying()
}