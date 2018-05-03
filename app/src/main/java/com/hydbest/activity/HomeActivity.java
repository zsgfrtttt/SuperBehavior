package com.hydbest.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.hydbest.Adapter.HomeAdapter;
import com.hydbest.BaseActivity;
import com.hydbest.behavior.R;

import java.util.Arrays;

/**
 * Created by csz on 2018/5/3.
 */

public class HomeActivity extends BaseActivity {
    private Class<Activity>[] mList = new Class[]{SampleTitleActivity.class,ScrollActivity.class,UCActivity.class};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BaseQuickAdapter adapter = new HomeAdapter(Arrays.asList(mList));
        recyclerView = findViewById(R.id.my_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        adapter.setOnRecyclerViewItemClickListener(new BaseQuickAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, int i) {
                startActivity(new Intent(HomeActivity.this,mList[i]));
            }
        });
    }


}
