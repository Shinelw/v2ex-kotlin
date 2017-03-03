package com.shinelw.v2ex.contract

import com.shinelw.v2ex.model.bean.Topic

/**
 * Created by peixuan on 2017/3/3.
 */
interface TopicListContract {
    interface View{
        fun setData(list:List<Topic>)
    }

    interface Model{
        fun getData(): List<Topic>
    }

    interface Presenter{
        fun getData()
    }
}