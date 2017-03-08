package com.shinelw.v2ex.presenter

import com.shinelw.v2ex.contract.TopicListContract
import com.shinelw.v2ex.model.TopicModel
import com.shinelw.v2ex.model.bean.Topic

/**
 * Created by peixuan on 2017/3/3.
 */
class TopicListPresenter(private val view: TopicListContract.View) : TopicListContract.Presenter, TopicListContract.Listener{
    private val model: TopicModel = TopicModel()
    override fun getData(type: String) {
        model.getData(type, this@TopicListPresenter)
    }

    override fun onFail(msg: String) {

    }

    override fun onSucceed(list: List<Topic>) {
        view.setData(list)
    }
}