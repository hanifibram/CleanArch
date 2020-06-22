package com.hnf.cleanarch.di.component

import android.app.Application
import android.content.Context
import com.hnf.cleanarch.CleanArchApp
import com.hnf.cleanarch.di.module.ApplicationModule
import com.hnf.data.di.ApiModule
import com.hnf.data.di.NetworkModule
import com.hnf.domain.movies.MoviesRepository
import dagger.Component
import javax.inject.Singleton


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version ApplicationComponent, v 0.1 22/06/20 01.50 by Hanif Ibrahim
 */
@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        ApiModule::class
    ]
)
interface ApplicationComponent {

    fun inject(cleanArchApp: CleanArchApp)

    fun context(): Context

    fun application(): Application

    fun moviesRepository(): MoviesRepository
}