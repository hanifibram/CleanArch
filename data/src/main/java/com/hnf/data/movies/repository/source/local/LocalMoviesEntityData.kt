package com.hnf.data.movies.repository.source.local

import com.hnf.data.movies.repository.MoviesEntityData
import com.hnf.data.movies.repository.source.network.result.MovieResult
import com.hnf.data.movies.repository.source.network.result.MoviesResult
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version LocalMoviesEntityData, v 0.1 22/06/20 02.10 by Hanif Ibrahim
 */
class LocalMoviesEntityData @Inject constructor(
) : MoviesEntityData {
    override fun nowPlaying(): Observable<MoviesResult> {
        TODO("Not yet implemented")
    }
}