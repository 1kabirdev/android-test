package com.android_test.motion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import com.android_test.R
import com.android_test.databinding.ActivityMotionSceneBinding

class MotionSceneActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMotionSceneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMotionSceneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            motionLayout.setTransitionListener(object : TransitionAdapter() {
                override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                    when (currentId) {
                        R.id.offScreenPass -> {
                            Toast.makeText(this@MotionSceneActivity, "Pass", Toast.LENGTH_SHORT)
                                .show()
                            motionLayout.progress = 0f
                            motionLayout.setTransition(R.id.rest, R.id.like)
                        }
                        R.id.offScreenLike -> {
                            Toast.makeText(this@MotionSceneActivity, "Like", Toast.LENGTH_SHORT)
                                .show()
                            motionLayout.progress = 0f
                            motionLayout.setTransition(R.id.rest, R.id.like)
                        }
                    }
                }
            })
        }
    }
}