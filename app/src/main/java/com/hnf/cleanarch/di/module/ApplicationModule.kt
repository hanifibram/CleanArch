package com.hnf.cleanarch.di.module

import android.app.Application
import android.content.Context
import com.hnf.data.movies.repository.MoviesEntityRepository
import com.hnf.domain.movies.MoviesRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version ApplicationModule, v 0.1 22/06/20 01.50 by Hanif Ibrahim
 */
@Module
class ApplicationModule(private val application: Application) {

    @Provides
    @Singleton
    fun provideApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    @Singleton
    fun provideMoviesRepository(moviesEntityRepository: MoviesEntityRepository): MoviesRepository =
        moviesEntityRepository
}