package com.shinelw.v2ex.ui.widget

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by peixuan on 2017/3/2.
 */
class TopicItemDecoration(val distance: Int, val unit: Int, val context: Context) : RecyclerView.ItemDecoration(){

    companion object {
        val UNIT_DP = 0
        val UNIT_PX = 1
    }

    override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutparams: RecyclerView.LayoutParams = view?.layoutParams as RecyclerView.LayoutParams
        val position : Int = layoutparams.viewLayoutPosition
        if (position > -1){
            if (unit  == UNIT_DP){
                val density: Float = context.resources.displayMetrics.density
                val size: Int = (unit * density + 0.5f).toInt()
                outRect?.set(0, size, 0, 0)
            }else {
                outRect?.set(0, distance, 0, 0)
            }
        }
    }

}