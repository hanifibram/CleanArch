package com.hnf.cleanarch.di.module

import com.hnf.cleanarch.feature.nowplaying.NowPlayingContract
import com.hnf.cleanarch.feature.nowplaying.NowPlayingPresenter
import dagger.Module
import dagger.Provides


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NowPlayingModule, v 0.1 22/06/20 04.45 by Hanif Ibrahim
 */
@Module
class NowPlayingModule(private val nowPlayingView: NowPlayingContract.View) {

    @Provides
    fun provideNowPlayingPresenter(nowPlayingPresenter: NowPlayingPresenter): NowPlayingContract.Presenter =
        nowPlayingPresenter

    @Provides
    fun provideNowPlayingView(): NowPlayingContract.View = nowPlayingView
}