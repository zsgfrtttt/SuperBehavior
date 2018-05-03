package com.hydbest.Adapter;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */

public class HomeAdapter extends BaseQuickAdapter<Class<Activity>> {

    public HomeAdapter(List<Class<Activity>> data) {
        super(android.R.layout.simple_expandable_list_item_1,data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, Class<Activity> s) {
        baseViewHolder.setText(android.R.id.text1,s.getSimpleName());
    }
}
