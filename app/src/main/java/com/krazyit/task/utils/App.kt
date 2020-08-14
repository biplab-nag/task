package com.krazyit.task.utils

import android.app.Application
import android.content.Context
import timber.log.Timber
import java.lang.ref.WeakReference

class App: Application() {

    var mContext: WeakReference<Context>? = null

    companion object {
        lateinit  var appContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        appContext = applicationContext
        Timber.plant(Timber.DebugTree())
    }

}