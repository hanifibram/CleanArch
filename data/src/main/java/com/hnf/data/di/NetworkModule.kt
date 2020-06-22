package com.hnf.data.di

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.hnf.data.BuildConfig
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version NetworkModule, v 0.1 22/06/20 02.28 by Hanif Ibrahim
 */
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun provideGson(): Gson =
        GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .create()

    @Provides
    @Singleton
    fun provideCache(context: Context): Cache {
        val file = File(context.filesDir, DEFAULT_CACHE_FILE_NAME)
        return Cache(file, DEFAULT_CACHE_SIZE)
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        cache: Cache
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(DEFAULT_CONNECT_TIME_OUT, TimeUnit.MILLISECONDS)
            .readTimeout(DEFAULT_READ_TIME_OUT, TimeUnit.MILLISECONDS)
            .cache(cache)
            .addInterceptor(httpLoggingInterceptor)
            .addInterceptor { addQueryParam(it) }
            .build()

    private fun addQueryParam(it: Interceptor.Chain): Response {
        var request = it.request()
        val url = request.url()
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.MOVIE_DB_KEY)
            .build()
        request = request
            .newBuilder()
            .url(url)
            .build()
        return it.proceed(request)
    }

    @Provides
    @Singleton
    fun provideRetrofitBuilder(gson: Gson, okHttpClient: OkHttpClient): Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
    }

    companion object {

        private const val DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ssZ"
        private const val DEFAULT_CACHE_FILE_NAME = "okhttp-cache"
        private const val DEFAULT_CACHE_SIZE: Long = 1024 * 1024 // 1 MB
        private const val DEFAULT_CONNECT_TIME_OUT: Long = 30 * 1000
        private const val DEFAULT_READ_TIME_OUT: Long = 30 * 1000
    }

}