package com.android_test.custom_view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_test.databinding.ActivityCustomViewBinding

class CustomViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCustomViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}