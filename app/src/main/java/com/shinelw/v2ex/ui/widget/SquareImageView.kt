package com.shinelw.v2ex.ui.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageView

/**
 * Created by peixuan on 2017/3/2.
 */

class SquareImageVie : ImageView {

    constructor(context: Context) : super(context)
    @JvmOverloads constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int = 0) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec)
    }
}
