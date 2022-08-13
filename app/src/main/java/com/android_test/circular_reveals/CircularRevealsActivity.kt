package com.android_test.circular_reveals

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import androidx.core.content.res.ResourcesCompat
import com.android_test.R
import com.android_test.databinding.ActivityCirculerrevealsBinding
import kotlin.math.hypot

class CircularRevealsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCirculerrevealsBinding

    private var isOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCirculerrevealsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            floatingButton.setOnClickListener {
                revealMenu()
            }
        }
    }

    private fun revealMenu() {
        if (!isOpen) {
            val x = binding.mainLayout.right
            val y = binding.mainLayout.bottom

            val startRadius = 0
            val endRadius =
                hypot(binding.mainLayout.width.toDouble(), binding.mainLayout.height.toDouble())

            binding.floatingButton.backgroundTintList = ColorStateList.valueOf(
                ResourcesCompat
                    .getColor(applicationContext.resources, android.R.color.white, null)
            )
            binding.floatingButton.setImageResource(R.drawable.ic_baseline_add_24)
            val anim = ViewAnimationUtils.createCircularReveal(
                binding.mainLayout,
                x, y, startRadius.toFloat(), endRadius.toFloat()
            )
            anim.duration = 800
            binding.mainLayout.visibility = View.VISIBLE
            anim.start()
            isOpen = true
        } else {
            val x = binding.layoutText.left
            val y = binding.layoutText.top

            val startRadius = 0
            val end =
                hypot(binding.mainLayout.width.toDouble(), binding.mainLayout.height.toDouble())

            binding.floatingButton.backgroundTintList = ColorStateList.valueOf(
                ResourcesCompat
                    .getColor(applicationContext.resources, R.color.colorPrimary, null)
            )
            binding.floatingButton.setImageResource(R.drawable.ic_baseline_add_24)
            val anim = ViewAnimationUtils.createCircularReveal(
                binding.layoutText,
                x, y, startRadius.toFloat(), end.toFloat()
            )
            anim.duration = 800
            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    super.onAnimationEnd(animation)
                    binding.mainLayout.visibility = View.GONE
                }
            })
            anim.start()
            isOpen = false
        }
    }
}