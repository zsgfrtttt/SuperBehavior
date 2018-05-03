package com.hydbest.behavior;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by csz on 2018/5/2.
 * 设置recycleView的behavior
 */

public class RecycleBehavior extends CoordinatorLayout.Behavior<View>{

    public RecycleBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {
        return dependency instanceof TextView;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {
        float y = dependency.getHeight() + dependency.getTranslationY();
        if (y < 0) {
            y = 0;
        }
        child.setY(y);
        return true;
    }

}
