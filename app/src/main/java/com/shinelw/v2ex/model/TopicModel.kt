package com.shinelw.v2ex.model

import com.shinelw.v2ex.api.V2exApi
import com.shinelw.v2ex.contract.TopicListContract
import com.shinelw.v2ex.model.bean.Topic
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by peixuan on 2017/3/3.
 */
class TopicModel : TopicListContract.Model{

    override fun getData(type: String, listener: TopicListContract.Listener) {
        val retrofit: Retrofit = Retrofit.Builder()
                .baseUrl(V2exApi.HTTP_API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        val vtexapi: V2exApi = retrofit.create(V2exApi::class.java)
        var call: Call<List<Topic>> = vtexapi.getTopicListByNode(type)
        call.enqueue(object: Callback<List<Topic>> {
            override fun onResponse(call: Call<List<Topic>>?, response: Response<List<Topic>>?) {
                if (response?.body() != null) {
                    listener.onSucceed(response.body())
                }
            }
            override fun onFailure(call: Call<List<Topic>>?, t: Throwable?) {
                    listener.onFail(t.toString())
            }

        })
    }
}