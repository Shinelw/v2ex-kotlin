package com.shinelw.v2ex.model

import com.shinelw.v2ex.api.V2exApi
import com.shinelw.v2ex.contract.TopicListContract
import com.shinelw.v2ex.model.bean.Topic
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by peixuan on 2017/3/3.
 */
class TopicModel : TopicListContract.Model{
    override fun getData(): List<Topic> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(V2exApi.HTTP_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val vtexapi: V2exApi = retrofit.create(V2exApi::class.java)
        var call: Call<List<Topic>> = vtexapi.getLatestList()
        call.enqueue(object: Callback<List<Topic>> {
            override fun onResponse(call: Call<List<Topic>>?, response: Response<List<Topic>>?) {

            }
            override fun onFailure(call: Call<List<Topic>>?, t: Throwable?) {

            }

        })
    }
}