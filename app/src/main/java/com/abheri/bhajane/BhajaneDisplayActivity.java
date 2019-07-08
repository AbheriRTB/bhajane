package com.abheri.bhajane;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.view.GestureDetector;

public class BhajaneDisplayActivity extends Activity {

    RecyclerView bhajaneRV;
    BhajaneData[] myListData;
    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bhajane_page_group);

        bhajaneRV = findViewById(R.id.bhajaniRecyclerView);
        Intent intent = getIntent();
        int position = intent.getIntExtra("PageSelected", 0);

        myListData = Util.makeContent(this);
        BajanePageAdapter bpa = new BajanePageAdapter(myListData,this);

        //bhajaneRV.setLayoutManager(new LinearLayoutManager(this));
        bhajaneRV.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(bhajaneRV);

        bhajaneRV.setAdapter(bpa);
        bhajaneRV.scrollToPosition(position);
    }

}
