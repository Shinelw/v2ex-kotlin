package com.shinelw.v2ex.api

import retrofit2.http.GET

/**
 * Created by peixuan on 2017/3/1.
 */
interface V2exApi {

    /**
     * 获取最新列表
     */
    @GET("/topics/latest.json")
    fun getLastList()

    /**
     * 获取最热列表
     */
    @GET("/topics/hot.json")
    fun getHotList()

    /**
     * 获取所有节点
     */
    @GET("/nodes/all.json")
    fun getAllNodes()

    /**
     * 获取主题内容
     */
    @GET("/topics/show.json")
    fun getTopicsContent()


}