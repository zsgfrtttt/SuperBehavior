package com.hydbest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.SwipeDismissBehavior;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.hydbest.BaseActivity;
import com.hydbest.behavior.R;

/**
 * Created by csz on 2018/5/4.
 */

public class SwipeDismissActivity extends BaseActivity{
    private LinearLayout mSwipeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipedismiss);
        init();
    }

    private void init() {
        mSwipeLayout = findViewById(R.id.swipe_layout);
        SwipeDismissBehavior swipe = new SwipeDismissBehavior();

        /**
         * //设置滑动的方向，有3个值
         * 1，SWIPE_DIRECTION_ANY 表示向左像右滑动都可以，
         * 2，SWIPE_DIRECTION_START_TO_END，只能从左向右滑
         * 3，SWIPE_DIRECTION_END_TO_START，只能从右向左滑
         */
        swipe.setSwipeDirection(SwipeDismissBehavior.SWIPE_DIRECTION_START_TO_END);
        swipe.setStartAlphaSwipeDistance(1f);
        swipe.setSensitivity(1f);

        swipe.setListener(new SwipeDismissBehavior.OnDismissListener() {
            @Override
            public void onDismiss(View view) {
                Log.e("csz","------>onDissmiss");
            }

            @Override
            public void onDragStateChanged(int state) {
                Log.e("csz","------>onDragStateChanged");
            }
        });

        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) mSwipeLayout.getLayoutParams();
        if(layoutParams!=null){
            layoutParams.setBehavior(swipe);
        }
    }
}
