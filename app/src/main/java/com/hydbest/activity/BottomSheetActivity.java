package com.hydbest.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hydbest.Adapter.TextAdapter;
import com.hydbest.BaseActivity;
import com.hydbest.behavior.R;

/**
 * Created by csz on 2018/5/4.
 */

public class BottomSheetActivity extends BaseActivity {
    private RecyclerView rv;

    /**
     * STATE_EXPANDED 展开状态，显示完整布局。
     * STATE_COLLAPSED 折叠状态，显示peekHeigth 的高度，如果peekHeight为0，则全部隐藏,与STATE_HIDDEN效果一样。
     * STATE_DRAGGING  拖拽时的状态
     * STATE_HIDDEN 隐藏时的状态
     * STATE_SETTLING  释放时的状态
     */
    private BottomSheetBehavior<View> behavior;
    private BottomSheetDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_sheet);
        rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new TextAdapter(null));
        behavior = BottomSheetBehavior.from(findViewById(R.id.share_view));
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        //下滑的时候是否可以隐藏
        behavior.setHideable(true);
        findViewById(R.id.btn_show_bottom_sheet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (behavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                } else {
                    behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                }

            }
        });
        findViewById(R.id.btn_show_bottom_sheet_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });
    }

    private void showBottomSheetDialog(){
        if (dialog == null) {
            dialog = new BottomSheetDialog(this);
            View view = LayoutInflater.from(this).inflate(R.layout.fragment_content, null);
            RecyclerView rv = view.findViewById(R.id.recyclerView);
            rv.setLayoutManager(new LinearLayoutManager(this));
            rv.setAdapter(new TextAdapter(null));

            dialog.setContentView(view);
            dialog.setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);

            // 解决下滑隐藏dialog 后，再次调用show 方法显示时，不能弹出Dialog
            View view1 = dialog.getDelegate().findViewById(android.support.design.R.id.design_bottom_sheet);
            ViewGroup.LayoutParams params = view1.getLayoutParams();
            params.height= 300;
            final BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from(view1);
            bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
                @Override
                public void onStateChanged(@NonNull View bottomSheet, int newState) {
                    if (newState == BottomSheetBehavior.STATE_HIDDEN) {
                        dialog.dismiss();
                        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
                    }
                }

                @Override
                public void onSlide(@NonNull View bottomSheet, float slideOffset) {

                }
            });
        }else {
            dialog.show();
        }
    }

}
