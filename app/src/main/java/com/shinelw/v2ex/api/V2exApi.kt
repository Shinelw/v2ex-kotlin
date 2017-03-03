package com.shinelw.v2ex.api

import com.shinelw.v2ex.model.bean.Topic
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by peixuan on 2017/3/1.
 */
interface V2exApi {

    /**
     * baseURL
     */
    companion object {
        val HTTP_API_URL = "http://www.v2ex.com/api/"
        val HTTPS_API_URL = "https://www.v2ex.com/api/"

        val HTTP_BASE_URL = "http://www.v2ex.com/"
        val HTTPS_BASE_URL = "https://www.v2ex.com/"
    }

    /**
     * 获取最新列表
     */
    @GET("topics/latest.json")
    fun getLatestList(): Call<List<Topic>>

    /**
     * 获取最热列表
     */
    @GET("topics/hot.json")
    fun getHotList()

    /**
     * 获取某个节点的主题
     */
    @GET("topics/show.json")
    fun getTopicListByNode(@Query("node_name") name: String): Call<List<Topic>>

    /**
     * 获取所有节点
     */
    @GET("nodes/all.json")
    fun getAllNodes()

    /**
     * 获取主题内容
     */
    @GET("topics/show.json")
    fun getTopicsContent(@Query("id") id: Int)

    /**
     * 根据用户名获取用户主页
     */
    @GET("api/members/show.json")
    fun getUserHomePagerByName(@Query("username") username: String)

    /**
     * 根据用户id获取用户主页
     */
    @GET("api/members/show.json")
    fun getUserHomePagerById(@Query("username") username: String)

    /**
     * 根据主题id获取回复列表
     */
    @GET("replies/show.json")
    fun getAllReplies(@Query("topic_id") id: Int)




}