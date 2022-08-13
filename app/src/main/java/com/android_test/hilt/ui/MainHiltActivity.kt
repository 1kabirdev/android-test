package com.android_test.hilt.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_test.App
import com.android_test.databinding.ActivityMainHiltBinding
import com.android_test.hilt.navigator.AppNavigator
import com.android_test.hilt.navigator.Screens

class MainHiltActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainHiltBinding
    private lateinit var navigator: AppNavigator
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainHiltBinding.inflate(layoutInflater)
        setContentView(binding.root)

        navigator = (applicationContext as App).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}