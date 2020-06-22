package com.hnf.data.movies.repository

import com.hnf.data.common.Source
import com.hnf.data.movies.mapper.MoviesResultMapper
import com.hnf.data.movies.repository.source.MoviesDataFactory
import com.hnf.domain.movies.MoviesRepository
import com.hnf.domain.movies.model.Movie
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesEntityRepository, v 0.1 22/06/20 02.04 by Hanif Ibrahim
 */
class MoviesEntityRepository @Inject constructor(
    private val moviesEntityDataFactory: MoviesDataFactory,
    private val moviesResultMapper: MoviesResultMapper
) : MoviesRepository {

    override fun getNowPlaying(): Observable<List<Movie>> =
        createMoviesData().nowPlaying()
            .map { moviesResultMapper.transform(it) }

    private fun createMoviesData(): MoviesEntityData =
        moviesEntityDataFactory.createData(Source.NETWORK)
}