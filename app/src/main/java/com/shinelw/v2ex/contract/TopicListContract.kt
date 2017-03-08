package com.shinelw.v2ex.contract

import com.shinelw.v2ex.model.bean.Topic
import retrofit2.Response

/**
 * Created by peixuan on 2017/3/3.
 */
interface TopicListContract {
    interface View{
        fun setData(list:List<Topic>)
    }

    interface Model{
        fun getData(type: String, listener: Listener)
    }

    interface Presenter{
        fun getData(type: String)
    }

    interface Listener{
        fun onSucceed(list: List<Topic>)
        fun onFail(msg: String)
    }
}