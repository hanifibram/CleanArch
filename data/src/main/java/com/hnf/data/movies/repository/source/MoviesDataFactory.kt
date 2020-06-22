package com.hnf.data.movies.repository.source

import com.hnf.data.common.Source
import com.hnf.data.movies.repository.MoviesEntityData
import com.hnf.data.movies.repository.source.local.LocalMoviesEntityData
import com.hnf.data.movies.repository.source.network.MoviesApi
import com.hnf.data.movies.repository.source.network.NetworkMoviesEntityData
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesDataFactory, v 0.1 22/06/20 02.07 by Hanif Ibrahim
 */
class MoviesDataFactory @Inject constructor(
    private val moviesApi: MoviesApi
) {

    fun createData(source: Source): MoviesEntityData =
        when (source) {
            Source.NETWORK -> NetworkMoviesEntityData(moviesApi)
            Source.LOCAL -> LocalMoviesEntityData()
//            Source.MOCK -> MockMoviesEntity()
        }
}