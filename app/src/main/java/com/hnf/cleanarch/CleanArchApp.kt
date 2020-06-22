package com.hnf.cleanarch

import android.app.Application
import com.hnf.cleanarch.di.component.ApplicationComponent
import com.hnf.cleanarch.di.component.DaggerApplicationComponent
import com.hnf.cleanarch.di.module.ApplicationModule
import com.hnf.data.di.ApiModule
import com.hnf.data.di.NetworkModule


/**
 * @author Hanif Ibrahim (hanif.ibrahim@dana.id)
 * @version CleanArchApp, v 0.1 22/06/20 01.52 by Hanif Ibrahim
 */
class CleanArchApp : Application() {

    val applicationComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .apiModule(ApiModule())
            .networkModule(NetworkModule())
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent.inject(this)
    }
}