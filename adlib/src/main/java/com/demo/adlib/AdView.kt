package com.demo.adlib

import android.content.Context
import android.util.AttributeSet
import android.view.animation.AnimationUtils
import android.widget.ViewFlipper

/**
 *
 *   created by  liushu
 *   created on  2019-10-16
 *   description：轮播view
 *
 **/
class AdView : ViewFlipper {

    private var mAdInterval = DEFAULT_INTERVAL
    private var mAdEnterAnim = DEFAULT_ENTER_ANIM
    private var mAdLeaveAnim = DEFAULT_LEAVE_ANIM
    private var mAdFlipNum = DEFAULT_FLIP_NUM

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val a = context.obtainStyledAttributes(attrs, R.styleable.AdView)
        mAdInterval = a.getInt(R.styleable.AdView_adInterval, DEFAULT_INTERVAL)
        mAdEnterAnim = a.getResourceId(R.styleable.AdView_adEnterAnim, DEFAULT_ENTER_ANIM)
        mAdLeaveAnim = a.getResourceId(R.styleable.AdView_adLeaveAnim, DEFAULT_LEAVE_ANIM)
        mAdFlipNum = a.getResourceId(R.styleable.AdView_adFlipNum, DEFAULT_FLIP_NUM)
        a.recycle()
        init()
    }

    private fun init() {
        // 设置公告轮播间隔时间
        setFlipInterval(mAdInterval)
        // 设置进入和离开动画
        inAnimation = AnimationUtils.loadAnimation(context, mAdEnterAnim)
        outAnimation = AnimationUtils.loadAnimation(context, mAdLeaveAnim)
    }

    fun setAdapter(adapter: BaseAdAdapter<*>?) {
        //删除老的布局
        removeAllViews()
        if (adapter == null) {
            return
        }
        for (i in 0 until adapter.count) {
            val view = adapter.getView(i)
            view.tag = i
            addView(view)
        }
        //设置播放条件
        if (adapter.count > mAdFlipNum) {
            startFlipping()
        } else {
            stopFlipping()
        }
    }

    companion object {

        private val DEFAULT_INTERVAL = 3000 // 默认轮播间隔 3 秒
        private val DEFAULT_ENTER_ANIM = R.anim.ad_item_enter // 默认进入动画 平移加渐变
        private val DEFAULT_LEAVE_ANIM = R.anim.ad_item_leave // 默认离开动画 平移加渐变
        private val DEFAULT_FLIP_NUM = 0 //默认大于0条开始播放动画
    }

}