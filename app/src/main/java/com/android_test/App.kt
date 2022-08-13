package com.android_test

import android.app.Application
import com.android_test.hilt.ServiceLocator

class App : Application() {

    lateinit var serviceLocator: ServiceLocator
    override fun onCreate() {
        super.onCreate()
        serviceLocator = ServiceLocator(applicationContext)
    }
}