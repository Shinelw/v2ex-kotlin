package com.shinelw.v2ex.ui.fragment

import android.app.ActivityManager
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.LayoutInflaterFactory
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinelw.v2ex.R
import com.shinelw.v2ex.ui.adapter.HomeViewPagerAdapter
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter


/**
 * Created by peixuan on 2017/3/2.
 */
class TopicFragment(val type: String) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_list, container, false)
        val mRecyclerView= view?.findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.adapter = RecyclerViewAdapter()
        return view
    }
}