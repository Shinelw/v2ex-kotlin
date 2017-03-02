package com.shinelw.v2ex.model

/**
 * Created by peixuan on 2017/3/2.
 */
data class TopicModel(
        val id: Int,
        val title: String,
        val content: String,
        val content_rendered: String,
        val replies: Int,
        val created: Long,
        val last_modified: Long,
        val last_touched: Long,
        val member: MemeberModel,
        val node: NodeModel)