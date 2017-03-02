package com.shinelw.v2ex.ui.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.shinelw.v2ex.R
import com.shinelw.v2ex.ui.adapter.RecyclerViewAdapter.ViewHolder

/**
 * Created by peixuan on 2017/3/2.
 */
class RecyclerViewAdapter(val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.item_topic, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.topicTitle?.text = "1111"
    }


     public class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
         var topicTitle : TextView
//         var userName : TextView
//         var userImg : ImageView
        init {
            topicTitle = itemView?.findViewById(R.id.topName) as TextView
        }

    }

}