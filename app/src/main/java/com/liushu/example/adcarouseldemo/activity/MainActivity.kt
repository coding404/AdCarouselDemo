package com.liushu.example.adcarouseldemo.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.liushu.example.adcarouseldemo.*
import com.liushu.example.adcarouseldemo.adapter.*
import com.liushu.example.adcarouseldemo.conts.Conts
import com.liushu.example.adcarouseldemo.entity.SaleEntity
import com.liushu.example.adcarouseldemo.widget.AdView

import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var mList: MutableList<String>? = null

    private var mHeadAdapter: HeadAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initSimpleData()
        initComplexData()
        initShopData()
        initHeadData()
    }

    private fun initHeadData() {
        val head = findViewById<AdView>(R.id.bv_head)
        mHeadAdapter = HeadAdapter(this, null)
        mHeadAdapter?.setAdClickListener(object : BaseAdAdapter.IAdViewCLickListener {
            override fun onViewClick(tag: Any) {
                if (tag is String) {

                    when (tag) {
                        Conts.CONTENT_CLICK -> Toast.makeText(this@MainActivity, "" + tag, Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        head.setAdapter(mHeadAdapter)
    }

    private fun initShopData() {
        val mAdViewProduct = findViewById<AdView>(R.id.ad_view_product)
        mAdViewProduct.setAdapter(ProductsAdapter(this, null))
    }

    private fun initComplexData() {

        val mAdViewSale = findViewById<AdView>(R.id.ad_view_sale)
        val saleEntities = ArrayList<SaleEntity>()

        val saleEntity = SaleEntity()
        saleEntity.saleTitle = "第一条标题"
        saleEntity.salePrice = "标注1"
        saleEntity.saleTag = "新人专享"
        saleEntity.saleImgRes = R.color.colorPrimaryDark

        val saleEntity1 = SaleEntity()
        saleEntity1.saleTitle = "第二条标题"
        saleEntity1.salePrice = "标注2"
        saleEntity1.saleTag = "再减5元"
        saleEntity1.saleImgRes = R.color.colorAccent

        saleEntities.add(saleEntity)
        saleEntities.add(saleEntity1)

        mAdViewSale.setAdapter(SaleAdapter(this, saleEntities))
    }

    private fun initSimpleData() {

        val mAdView = findViewById<AdView>(R.id.ad_view_normal)
        val list = ArrayList<String>()
        list.add("苹果Mac book Pro 24期免息！")
        list.add("领券家电立减800");
        mAdView.setAdapter(SimpleAdAdapter(this, list))

    }

    override fun onClick(v: View) {
        if (v.tag is Int) {
            val position = v.tag as Int
            Toast.makeText(this, mList!![position], Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mHeadAdapter?.clearListener()
    }
}
