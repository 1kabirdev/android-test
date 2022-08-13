package com.android_test.hilt.utills

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

/**
 * String formatter for the log dates.
 */
class DateFormatter {

    @SuppressLint("SimpleDateFormat")
    private val formatter = SimpleDateFormat("d MMM yyyy HH:mm:ss")

    fun formatDate(timestamp: Long): String {
        return formatter.format(Date(timestamp))
    }
}