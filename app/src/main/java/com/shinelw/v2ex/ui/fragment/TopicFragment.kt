package com.shinelw.v2ex.ui.fragment

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shinelw.v2ex.R
import com.shinelw.v2ex.api.V2exApi
import com.shinelw.v2ex.contract.TopicListContract
import com.shinelw.v2ex.model.bean.Topic
import com.shinelw.v2ex.presenter.TopicListPresenter
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter
import com.shinelw.v2ex.ui.widget.TopicItemDecoration
import java.util.*


/**
 * Created by peixuan on 2017/3/2.
 */
class TopicFragment(val type: String) : Fragment(), TopicListContract.View{

    lateinit var mRecyclerView: RecyclerView
    var isRefresh : Boolean = true
    lateinit var swipeLayout: SwipeRefreshLayout
    var list: List<Topic> = ArrayList()
    lateinit var topicPresenter: TopicListPresenter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_list, container, false)

        swipeLayout = view?.findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        swipeLayout.isRefreshing = true
        mRecyclerView = view?.findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.adapter = RecyclerViewAdapter(context,list)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        topicPresenter = TopicListPresenter(this)
        topicPresenter.getData(type)
        val itemDecoration: TopicItemDecoration = TopicItemDecoration(1, TopicItemDecoration.UNIT_DP, context)
        mRecyclerView.addItemDecoration(itemDecoration)
        swipeLayout.setColorSchemeColors(Color.BLUE,
                Color.GREEN,
                Color.YELLOW,
                Color.RED)
        swipeLayout.setOnRefreshListener {

            if (!isRefresh){
                isRefresh = true
                swipeLayout.isRefreshing = true
                topicPresenter.getData(type)
            }
        }
        return view
    }
    override fun setData(list: List<Topic>) {
        if (mRecyclerView.adapter != null){
            (mRecyclerView.adapter as RecyclerViewAdapter).setData(list)
            mRecyclerView.adapter.notifyDataSetChanged()
            isRefresh = false
            swipeLayout.isRefreshing = false
        }
    }
}