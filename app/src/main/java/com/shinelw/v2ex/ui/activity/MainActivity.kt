package com.shinelw.v2ex.ui.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.shinelw.v2ex.R
import com.shinelw.v2ex.ui.adapter.HomeViewPagerAdapter
import com.shinelw.v2ex.ui.fragment.TopicFragment
import kotlinx.android.synthetic.main.layout_content.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val typeStr = arrayOf("技术", "创意", "好玩", "Apple", "酷工作", "交易", "城市", "问与答", "最热", "全部", "R2")
    val type = arrayOf("tech", "creative", "play", "apple", "jobs", "deals", "city", "qna", "hot", "all", "r2")
    var fragmentList: MutableList<Fragment> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        layout_tab.tabMode = TabLayout.MODE_SCROLLABLE
        layout_tab.setupWithViewPager(view_pager)
        val fragmentManager: FragmentManager = this@MainActivity.supportFragmentManager
        for (i in type.indices){
            val tab = layout_tab.newTab()
            tab.text = typeStr[i]
            layout_tab.addTab(tab)
            fragmentList.add(TopicFragment(type[i]))
        }
        view_pager.offscreenPageLimit = 5
        view_pager.adapter = HomeViewPagerAdapter(this, fragmentManager, fragmentList, typeStr)
        layout_tab.setupWithViewPager(view_pager)

    }
}
