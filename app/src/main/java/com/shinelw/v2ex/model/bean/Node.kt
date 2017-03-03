package com.shinelw.v2ex.model.bean

/**
 * Created by peixuan on 2017/3/2.
 */
data class Node(val id: Int,
                val name: String,
                val title: String,
                val title_alternative: String,
                val url: String,
                val topics: Int,
                val avatar_mini: String,
                val avatar_normal: String,
                val avatar_large: String) {
}