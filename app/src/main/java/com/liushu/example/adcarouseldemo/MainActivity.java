package com.liushu.example.adcarouseldemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private AdCarouseView mCarouseView;
    private List<String> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCarouseView = (AdCarouseView) findViewById(R.id.ad_view);
        initData();
    }

    private void initData() {
        mList=new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mList.add("这是第"+i+"条！");
        }
        mCarouseView.startWithList(mList);
        mCarouseView.setListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getTag() instanceof Integer) {
            int position = (int) v.getTag();
            Toast.makeText(this, mList.get(position), Toast.LENGTH_SHORT).show();
        }
    }
}
