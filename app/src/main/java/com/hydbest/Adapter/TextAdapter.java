package com.hydbest.Adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/5/2.
 */

public class TextAdapter extends BaseQuickAdapter<String> {
    private static final ArrayList<String> list;

    static {
        list = new ArrayList<>();
        for (int i=0;i<30;i++){
            list.add(i+"");
        }
    }
    public TextAdapter(List<String> data) {
        super(android.R.layout.simple_expandable_list_item_1,list);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, String s) {
        baseViewHolder.setText(android.R.id.text1,"hahah");
    }
}
