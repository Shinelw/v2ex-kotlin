package com.shinelw.v2ex.model.bean

import com.shinelw.v2ex.model.bean.Memeber
import com.shinelw.v2ex.model.bean.Node

/**
 * Created by peixuan on 2017/3/2.
 */
data class Topic(
        val id: Int,
        val title: String,
        val content: String,
        val content_rendered: String,
        val replies: Int,
        val created: Long,
        val last_modified: Long,
        val last_touched: Long,
        val member: Memeber,
        val node: Node)