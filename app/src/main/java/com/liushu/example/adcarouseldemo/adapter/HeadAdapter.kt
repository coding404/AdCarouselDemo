package com.liushu.example.adcarouseldemo.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import com.liushu.example.adcarouseldemo.R
import com.liushu.example.adcarouseldemo.conts.Conts

/**
 * created by  liushu
 * created on  2019-09-09
 * description：
 */
class HeadAdapter(context: Context, list: List<Any>?) : BaseAdAdapter<Any>(context, list) {

    override val count: Int
        get() = 5

    override fun getView(position: Int): View {
        val rootView = getRootView(R.layout.item_head)
        val llContent = rootView.findViewById<LinearLayout>(R.id.ll_content)
        val ivGo = rootView.findViewById<ImageView>(R.id.iv_go)
        llContent.setOnClickListener {

            mAdClickListener?.onViewClick(Conts.CONTENT_CLICK)
        }

       /* ivGo.setOnClickListener {
            mAdClickListener?.onViewClick(Conts.GO_ICON)
        }*/

        return rootView
    }
}
