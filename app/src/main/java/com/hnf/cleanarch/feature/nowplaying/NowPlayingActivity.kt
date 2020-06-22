package com.hnf.cleanarch.feature.nowplaying

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hnf.cleanarch.CleanArchApp
import com.hnf.cleanarch.R
import com.hnf.cleanarch.di.component.DaggerNowPlayingComponent
import com.hnf.cleanarch.di.module.NowPlayingModule
import com.hnf.domain.movies.model.Movie
import kotlinx.android.synthetic.main.activity_now_playing.*
import javax.inject.Inject

class NowPlayingActivity : AppCompatActivity() {

    @Inject
    lateinit var nowPlayingPresenter: NowPlayingContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_now_playing)
        initInject()

        nowPlayingPresenter.getNowPlaying()
    }

    private fun initInject() {
        DaggerNowPlayingComponent.builder()
            .applicationComponent((application as CleanArchApp).applicationComponent)
            .nowPlayingModule(NowPlayingModule(object : NowPlayingContract.View {
                override fun onGetNowPlayingSuccess(movies: List<Movie>) {
                    tvData?.text = movies.size.toString()
                }

                override fun onGetNowPlayingFailed(message: String) {
                    tvData?.text = message
                }
            }))
            .build()
            .inject(this)
    }
}