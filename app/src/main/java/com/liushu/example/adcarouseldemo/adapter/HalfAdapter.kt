package com.liushu.example.adcarouseldemo.adapter

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.demo.adlib.BaseAdAdapter
import com.liushu.example.adcarouseldemo.R
import com.liushu.example.adcarouseldemo.entity.SaleEntity

/**
 * created by  liushu
 * created on  2019-09-08
 * description：
 */
class HalfAdapter(context: Context, data: List<SaleEntity>) : BaseAdAdapter<SaleEntity>(context, data) {

    override fun getView(position: Int): View {
        val view = getRootView(R.layout.item_sale)
        val imageView = view.findViewById<View>(R.id.img_sale) as ImageView
        val tVSaleTitle = view.findViewById<View>(R.id.tv_sale_title) as TextView
        val tVSalePrice = view.findViewById<View>(R.id.tv_sale_price) as TextView
        val tVSaleTag = view.findViewById<View>(R.id.tv_sale_tag) as TextView

        val saleEntity = mData!![position]
        imageView.setImageResource(R.color.colorAccent)
        tVSaleTitle.text = saleEntity.saleTitle
        tVSalePrice.text = saleEntity.salePrice
        tVSaleTag.text = saleEntity.saleTag

        return view
    }
}
