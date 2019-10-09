package com.liushu.example.adcarouseldemo.adapter

import android.content.Context
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import com.liushu.example.adcarouseldemo.R

/**
 * created by  liushu
 * created on  2019-09-08
 * description：
 */
class ProductsAdapter(context: Context, list: List<Any>?) : BaseAdAdapter<Any>(context, list) {

    override val count: Int
        get() = 2

    override fun getView(position: Int): View {
        val view: View
        if (position % 2 == 0) { //
            view = getRootView(R.layout.item_product_first)
            val llHot=view.findViewById<LinearLayout>(R.id.ll_hot)
            llHot.setOnClickListener {
                Toast.makeText(context,"点击第$position 条人气",Toast.LENGTH_SHORT).show()
            }

        } else {
            view = getRootView(R.layout.item_product_second)

            val tvTag1 = view.findViewById<TextView>(R.id.tv_tag1)
            tvTag1.setOnClickListener {
                Toast.makeText(context,"点击第$position 条111",Toast.LENGTH_SHORT).show()
            }

            val tvTag2=view.findViewById<TextView>(R.id.tv_tag2)
            tvTag2.setOnClickListener {
                Toast.makeText(context,"点击第$position 条222",Toast.LENGTH_SHORT).show()
            }

            val tvBottom = view.findViewById<TextView>(R.id.tv_bottom)
            tvBottom?.setOnClickListener {
                Toast.makeText(context,"点击第$position 条底部按钮",Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}
