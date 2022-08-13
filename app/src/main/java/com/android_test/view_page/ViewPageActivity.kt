package com.android_test.view_page

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android_test.databinding.ActivityViewPageBinding

class ViewPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityViewPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            val adapter = PageAdapter(supportFragmentManager)
            viewPager.adapter = adapter
        }
    }
}