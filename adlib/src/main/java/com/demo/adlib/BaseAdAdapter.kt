package com.demo.adlib

import android.content.Context
import android.view.LayoutInflater
import android.view.View

/**
 *
 *   created by  liushu
 *   created on  2019-10-16
 *   description：
 *
 **/
abstract class BaseAdAdapter<T>(protected var mContext: Context, protected var mData: List<T>? = null) {

    private val mLayoutInflater: LayoutInflater

    /**
     * 提供数据的大小
     *
     * @return 数据的大小
     */
    open val count: Int
        get() = if (mData == null) {
            0
        } else mData!!.size

    init {
        mLayoutInflater = LayoutInflater.from(mContext)
    }

    /**
     * 获得 item 根 View
     *
     * @param layoutID item 布局 ID
     * @return item 根 View
     */
    protected fun getRootView(layoutID: Int): View {
        return mLayoutInflater.inflate(layoutID, null)
    }

    /**
     * 提供具体的 View
     *
     * @param position view 所在的索引
     * @return 具体的 View
     */
    abstract fun getView(position: Int): View


}