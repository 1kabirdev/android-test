package com.android_test.view_page

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.android_test.view_page.fragment.PageOneFragment
import com.android_test.view_page.fragment.PageTwoFragment

class PageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int = 2

    override fun getItem(position: Int): Fragment {
        return if (position == 0) {
            PageOneFragment()
        } else {
            PageTwoFragment()
        }
    }
}