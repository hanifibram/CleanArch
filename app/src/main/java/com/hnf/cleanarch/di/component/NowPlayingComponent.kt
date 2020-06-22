package com.hnf.cleanarch.di.component

import com.hnf.cleanarch.di.PerActivity
import com.hnf.cleanarch.di.module.NowPlayingModule
import com.hnf.cleanarch.feature.nowplaying.NowPlayingActivity
import dagger.Component


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NowPlayingComponent, v 0.1 22/06/20 04.44 by Hanif Ibrahim
 */
@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [NowPlayingModule::class])
interface NowPlayingComponent {

    fun inject(nowPlayingActivity: NowPlayingActivity)
}