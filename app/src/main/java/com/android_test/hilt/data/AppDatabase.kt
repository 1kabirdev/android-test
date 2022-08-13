package com.android_test.hilt.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * SQLite Database for storing the logs.
 */
@Database(entities = [Log::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
}