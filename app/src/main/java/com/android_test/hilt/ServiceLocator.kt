package com.android_test.hilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.android_test.hilt.data.AppDatabase
import com.android_test.hilt.data.LoggerLocalDataSource
import com.android_test.hilt.navigator.AppNavigator
import com.android_test.hilt.navigator.AppNavigatorImpl
import com.android_test.hilt.utills.DateFormatter

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}