package com.hnf.domain.movies.interactor

import com.hnf.domain.UseCase
import com.hnf.domain.movies.MoviesRepository
import com.hnf.domain.movies.model.Movie
import io.reactivex.Observable
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version GetNowPlaying, v 0.1 22/06/20 03.47 by Hanif Ibrahim
 */
class GetNowPlaying @Inject constructor(
    private val moviesRepository: MoviesRepository
) : UseCase<List<Movie>, UseCase.None>() {

    override fun buildUseCase(params: None): Observable<List<Movie>> =
        moviesRepository.getNowPlaying()
    
}