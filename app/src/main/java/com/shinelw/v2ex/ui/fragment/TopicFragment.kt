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
import com.shinelw.v2ex.model.Topic
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter
import com.shinelw.v2ex.ui.widget.TopicItemDecoration
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response
import java.util.*


/**
 * Created by peixuan on 2017/3/2.
 */
class TopicFragment(val type: String) : Fragment() {
    lateinit var mRecyclerView: RecyclerView
    var isRefresh : Boolean = true
    lateinit var swipeLayout: SwipeRefreshLayout
    var list: List<Topic> = ArrayList()
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_list, container, false)

        swipeLayout = view?.findViewById(R.id.swipe_refresh) as SwipeRefreshLayout
        swipeLayout.isRefreshing = true
        mRecyclerView = view?.findViewById(R.id.recyclerView) as RecyclerView
        mRecyclerView.adapter = RecyclerViewAdapter(context,list)
        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mRecyclerView.itemAnimator = DefaultItemAnimator()
        getList()
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
                getList()

            }

        }
        return view
    }

    fun getList(){
        val retrofit: Retrofit = Retrofit.Builder()
                    .baseUrl(V2exApi.HTTP_API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
        val vtexapi: V2exApi = retrofit.create(V2exApi::class.java)
        var call: Call<List<Topic>> = vtexapi.getLatestList()
        call.enqueue(object: Callback<List<Topic>>{
            override fun onResponse(call: Call<List<Topic>>?, response: Response<List<Topic>>?) {
                isRefresh = false
                swipeLayout.isRefreshing = false
                if (response != null) {
                    list = response.body()
                }
                if (mRecyclerView.adapter != null){
                    (mRecyclerView.adapter as RecyclerViewAdapter).setData(list)
                    mRecyclerView.adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Topic>>?, t: Throwable?) {
                context.toast(t.toString())
            }

        })
    }
}