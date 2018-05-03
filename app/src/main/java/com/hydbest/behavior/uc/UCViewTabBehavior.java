package com.hydbest.behavior.uc;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

import com.hydbest.behavior.R;
import com.hydbest.behavior.base.HeaderScrollingViewBehavior;

import java.util.List;

/**
 * Created by csz on 2018/5/3.
 */

public class UCViewTabBehavior extends HeaderScrollingViewBehavior {
    private int mTitleViewHeight = 0;

    public UCViewTabBehavior() {

        super();
    }

    public UCViewTabBehavior(Context context, AttributeSet attrs) {

        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, View child, View dependency) {

        return isDependency(dependency);
    }

    @Override
    protected void layoutChild(CoordinatorLayout parent, View child, int layoutDirection) {

        mTitleViewHeight = parent.findViewById(R.id.news_view_title_layout).getMeasuredHeight();
        super.layoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, View child, View dependency) {

        //UCViewTab要滑动的距离为Header的高度减去TitleView的高度
        float offsetRange = mTitleViewHeight - dependency.getMeasuredHeight();
        //当Header向上滑动mTitleViewHeight高度后，即滑动完成
        int headerOffsetRange = -mTitleViewHeight;

        if(dependency.getTranslationY() == headerOffsetRange) {//Header已经上滑结束
            child.setTranslationY(offsetRange);
        } else if(dependency.getTranslationY() == 0) {//下滑结束，也是初始化的状态
            child.setTranslationY(0);
        } else {
            //UCViewTab与UCViewHeader为同向滑动
            //根据依赖UCViewHeader的滑动比例计算当前UCViewTab应该要滑动的值translationY
            child.setTranslationY(dependency.getTranslationY() / (headerOffsetRange * 1.0f) * offsetRange);
        }
        return false;
    }

    private boolean isDependency(View dependency) {

        return dependency != null && dependency.getId() == R.id.news_view_header_layout;
    }

    @Override
    public View findFirstDependency(List<View> views) {

        for(int i = 0; i < views.size(); i++) {
            if(isDependency(views.get(i))) {
                return views.get(i);
            }
        }
        return null;
    }
}
