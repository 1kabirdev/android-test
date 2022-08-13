package com.android_test.hilt.navigator

import androidx.fragment.app.FragmentActivity
import com.android_test.R
import com.android_test.hilt.ui.ButtonsFragment
import com.android_test.hilt.ui.LogsFragment


/**
 * Navigator implementation.
 */
class AppNavigatorImpl(private val activity: FragmentActivity) : AppNavigator {

    override fun navigateTo(screen: Screens) {
        val fragment = when (screen) {
            Screens.BUTTONS -> ButtonsFragment()
            Screens.LOGS -> LogsFragment()
        }

        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_container, fragment)
            .addToBackStack(fragment::class.java.canonicalName)
            .commit()
    }
}