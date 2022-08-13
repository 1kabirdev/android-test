package com.android_test

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.android_test.circular_reveals.CircularRevealsActivity
import com.android_test.custom_view.CustomViewActivity
import com.android_test.databinding.ActivityMainBinding
import com.android_test.element_transition.ElementTransitionActivity
import com.android_test.finger_print.FingerPrintActivity
import com.android_test.form_with_rx.FormWithRxActivity
import com.android_test.hilt.ui.MainHiltActivity
import com.android_test.motion.MotionSceneActivity
import com.android_test.view_page.ViewPageActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            /**
             * MotionScene Activities
             */
            clickMotionScene.setOnClickListener {
                startActivity(Intent(this@MainActivity, MotionSceneActivity::class.java))
            }

            /**
             * MyCustomView Activities
             */
            clickCustomView.setOnClickListener {
                startActivity(Intent(this@MainActivity, CustomViewActivity::class.java))
            }

            /**
             * Transition Activities Animation
             */
            cardView.setOnClickListener {
                val intent = Intent(this@MainActivity, ElementTransitionActivity::class.java)
                val options = ActivityOptionsCompat
                    .makeSceneTransitionAnimation(
                        this@MainActivity,
                        cardView as View, getString(R.string.transition_string)
                    )
                startActivity(intent, options.toBundle())
            }

            /**
             * ViewPage Activities
             */
            clickViewPage.setOnClickListener {
                startActivity(Intent(this@MainActivity, ViewPageActivity::class.java))
            }

            /**
             * Circular Reveals
             */
            clickCircular.setOnClickListener {
                startActivity(Intent(this@MainActivity, CircularRevealsActivity::class.java))
            }

            /**
             * Finger Print
             */
            clickFinger.setOnClickListener {
                startActivity(Intent(this@MainActivity, FingerPrintActivity::class.java))
            }

            /**
             * Form With Rx
             */
            clickFormWithRx.setOnClickListener {
                startActivity(Intent(this@MainActivity, FormWithRxActivity::class.java))
            }

            /**
             * Hilt
             */
            clickHilt.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainHiltActivity::class.java))
            }
        }
    }
}
