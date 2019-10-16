package com.liushu.example.adcarouseldemo.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.demo.adlib.AdView
import com.liushu.example.adcarouseldemo.*
import com.liushu.example.adcarouseldemo.adapter.*
import com.liushu.example.adcarouseldemo.entity.SaleEntity

import java.util.ArrayList

class MainActivity : AppCompatActivity(){

    private var mList: MutableList<String>? = null

    private var mHeadAdapter: HeadAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //简单布局
        initHeadData()
        initSimpleData()
        //半固定布局
        initHalfData()
        //多布局多点击事件
        initComplexData()
    }

    private fun initHeadData() {
        val head = findViewById<AdView>(R.id.bv_head_normal)
        mHeadAdapter = HeadAdapter(this, null)
        head.setAdapter(mHeadAdapter)
    }

    private fun initComplexData() {
        val mAdViewProduct = findViewById<AdView>(R.id.ad_view_product)
        mAdViewProduct.setAdapter(ProductsAdapter(this, null))
    }

    private fun initHalfData() {

        val mAdHalf = findViewById<AdView>(R.id.ad_half)
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

        mAdHalf.setAdapter(HalfAdapter(this, saleEntities))
    }

    private fun initSimpleData() {

        val mAdView = findViewById<AdView>(R.id.ad_view_normal)
        val list = ArrayList<String>()
        list.add("苹果Mac book Pro 24期免息！")
        list.add("领券家电立减800")
        mAdView.setAdapter(SimpleAdAdapter(this, list))
    }
}
