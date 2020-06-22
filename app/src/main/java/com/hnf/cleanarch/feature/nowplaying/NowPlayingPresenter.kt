package com.hnf.cleanarch.feature.nowplaying

import com.hnf.domain.UseCase
import com.hnf.domain.movies.interactor.GetNowPlaying
import javax.inject.Inject


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NowPlayingPresenter, v 0.1 22/06/20 04.37 by Hanif Ibrahim
 */
class NowPlayingPresenter @Inject constructor(
    private val getNowPlaying: GetNowPlaying,
    private val view: NowPlayingContract.View
) : NowPlayingContract.Presenter {

    override fun getNowPlaying() {
        getNowPlaying.execute(UseCase.None(), onSuccess = {
            view.onGetNowPlayingSuccess(it)
        }, onError = {
            view.onGetNowPlayingFailed("something went wrong")
        })
    }
}