package com.android_test.element_transition

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_test.databinding.ActivityElementTransitionBinding

class ElementTransitionActivity : AppCompatActivity() {
    private lateinit var binding: ActivityElementTransitionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityElementTransitionBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}