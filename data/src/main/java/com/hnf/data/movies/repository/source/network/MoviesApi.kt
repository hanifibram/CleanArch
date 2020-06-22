package com.hnf.data.movies.repository.source.network

import com.hnf.data.movies.repository.source.network.result.MovieResult
import com.hnf.data.movies.repository.source.network.result.MoviesResult
import io.reactivex.Observable
import retrofit2.http.GET


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version MoviesApi, v 0.1 22/06/20 02.18 by Hanif Ibrahim
 */
interface MoviesApi {

    @GET("movie/now_playing")
    fun nowPlaying(): Observable<MoviesResult>

}