package com.hnf.data.di

import com.hnf.data.BuildConfig
import com.hnf.data.movies.repository.source.network.MoviesApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version ApiModule, v 0.1 22/06/20 02.28 by Hanif Ibrahim
 */
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideMoviesApi(builder: Retrofit.Builder): MoviesApi =
        builder
            .build()
            .create(MoviesApi::class.java)

}