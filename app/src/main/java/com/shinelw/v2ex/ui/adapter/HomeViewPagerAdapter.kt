package com.shinelw.v2ex.ui.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.PagerAdapter
import android.view.View
import android.view.ViewGroup

/**
 * Created by peixuan on 2017/3/2.
 */
class HomeViewPagerAdapter(val context: Context, val fm: FragmentManager, val fragmentList: List<Fragment>, val tabTitle: Array<String>) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return tabTitle.size
    }

    override fun getItemPosition(`object`: Any?): Int {
        return `object` as Int
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitle[position]
    }


}