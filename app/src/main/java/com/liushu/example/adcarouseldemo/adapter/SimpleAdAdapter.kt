package com.liushu.example.adcarouseldemo.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.demo.adlib.BaseAdAdapter
import com.liushu.example.adcarouseldemo.R

/**
 * created by  liushu
 * created on  2019-09-08
 * description：
 */
class SimpleAdAdapter @JvmOverloads constructor(context: Context, dataList: List<String>, imageDrawableID: Int = R.drawable.icon_notice) : BaseAdAdapter<String>(context, dataList) {

    private var mImageDrawableID = R.drawable.icon_notice

    init {
        mImageDrawableID = imageDrawableID
    }

    override fun getView(position: Int): View {

        val view = getRootView(R.layout.simple_item)

        val imageView = view.findViewById<View>(R.id.iv_image) as ImageView
        val textView = view.findViewById<View>(R.id.tv_content) as TextView

        val data = mData!![position]
        imageView.setImageResource(mImageDrawableID)
        textView.text = data
        return view
    }

}
