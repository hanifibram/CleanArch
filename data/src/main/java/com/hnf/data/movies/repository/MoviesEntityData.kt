package com.hnf.data.movies.repository

import com.hnf.data.movies.repository.source.network.result.MovieResult
import com.hnf.data.movies.repository.source.network.result.MoviesResult
import io.reactivex.Observable


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesEntityData, v 0.1 22/06/20 02.04 by Hanif Ibrahim
 */
interface MoviesEntityData {

    fun nowPlaying(): Observable<MoviesResult>
}