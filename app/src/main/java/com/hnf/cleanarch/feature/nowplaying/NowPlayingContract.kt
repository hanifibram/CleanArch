package com.hnf.cleanarch.feature.nowplaying

import com.hnf.domain.movies.model.Movie


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NowPlayingContract, v 0.1 22/06/20 04.36 by Hanif Ibrahim
 */
interface NowPlayingContract {

    interface Presenter {
        fun getNowPlaying()
    }

    interface View {
        fun onGetNowPlayingSuccess(movies: List<Movie>)
        fun onGetNowPlayingFailed(message: String)
    }

}