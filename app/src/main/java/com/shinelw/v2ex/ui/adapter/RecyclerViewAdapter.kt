package com.shinelw.v2ex.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.shinelw.v2ex.R
import com.shinelw.v2ex.model.bean.Topic
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter.ViewHolder
import com.shinelw.v2ex.ui.widget.SquareImageView

/**
 * Created by peixuan on 2017/3/2.
 */
class RecyclerViewAdapter(val context: Context, var topicList: List<Topic>?) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return topicList?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        if (itemCount > 0 && holder is ViewHolder) {
            val topic: Topic = topicList!!.get(position)
            holder.userName.text = topic.member.username
            holder.topicComments.text = topic.replies.toString()
            holder.topicTips.text = topic.last_modified.toString()
            holder.topicNode.text = topic.node.title
            holder.topicTitle.text = topic.title
            Glide.with(context).load("http:" + topic.member.avatar_mini).into(holder.userImg)

        }
    }

    fun setData(topicList: List<Topic>?) {
        this.topicList = topicList
    }


     public class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
         val topicTitle : TextView
         val userName : TextView
         val userImg : SquareImageView
         val topicTips: TextView
         val topicNode: TextView
         val topicComments: TextView
        init {
            topicTitle = itemView?.findViewById(R.id.tv_topic_title) as TextView
            userName = itemView?.findViewById(R.id.tv_topic_name) as TextView
            userImg = itemView?.findViewById(R.id.iv_topic_face) as SquareImageView
            topicTips = itemView?.findViewById(R.id.tv_topic_tips) as TextView
            topicNode = itemView?.findViewById(R.id.tv_topic_node) as TextView
            topicComments = itemView?.findViewById(R.id.tv_topic_comment) as TextView
        }

    }


}