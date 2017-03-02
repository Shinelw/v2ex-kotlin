package com.shinelw.v2ex.ui.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.gson.Gson
import com.shinelw.v2ex.R
import com.shinelw.v2ex.api.V2exApi
import com.shinelw.v2ex.model.TopicModel
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter
import com.shinelw.v2ex.ui.widget.TopicItemDecoration
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response


/**
 * Created by peixuan on 2017/3/2.
 */
class TopicFragment(val type: String) : Fragment() {
    lateinit var mRecyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view: View? = inflater?.inflate(R.layout.fragment_list, container, false)
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(V2exApi.HTTP_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val vtexapi: V2exApi = retrofit.create(V2exApi::class.java)
        val call: Call<List<TopicModel>> = vtexapi.getLatestList()
        call.enqueue(object: Callback<List<TopicModel>>{
            override fun onResponse(call: Call<List<TopicModel>>?, response: Response<List<TopicModel>>?) {
                mRecyclerView = view?.findViewById(R.id.recyclerView) as RecyclerView
                mRecyclerView.adapter = RecyclerViewAdapter(context,response?.body())
                mRecyclerView.layoutManager = LinearLayoutManager(context)
                mRecyclerView.itemAnimator = DefaultItemAnimator()
                val itemDecoration: TopicItemDecoration = TopicItemDecoration(1, TopicItemDecoration.UNIT_DP, context)
                mRecyclerView.addItemDecoration(itemDecoration)
            }

            override fun onFailure(call: Call<List<TopicModel>>?, t: Throwable?) {

            }

        })

        return view
    }
}