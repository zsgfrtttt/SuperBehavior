package com.hydbest.behavior.header;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hydbest.behavior.R;

/**
 * Created by csz on 2018/5/4.
 */
public class HeaderBehavior extends CoordinatorLayout.Behavior<View> {
    public static final String TAG = "csz";

    private int mHeaderHeight ;
    private Context mContext;

    public HeaderBehavior(Context context, AttributeSet attributeSet){
        super(context,attributeSet);
        this.mContext = context;
    }

    @Override
    public boolean onLayoutChild(CoordinatorLayout parent, View child, int layoutDirection) {
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) child.getLayoutParams();
        if(params!=null && params.height == CoordinatorLayout.LayoutParams.MATCH_PARENT){
            child.layout(0,0,parent.getWidth(),parent.getHeight());
            child.setTranslationY(getHeaderHeight());
            return true;
        }
        return super.onLayoutChild(parent, child, layoutDirection);
    }

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
        return (axes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    @Override
    public void onNestedPreScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dx, int dy, @NonNull int[] consumed, int type) {
        super.onNestedPreScroll(coordinatorLayout, child, target, dx, dy, consumed, type);
        //处理向滑动
        if(dy < 0){
            float transY = child.getTranslationY() - dy;
            if(transY > 0 && transY <= getHeaderHeight()){
                child.setTranslationY(transY);
                consumed[1]= dy;
            }else if (transY > getHeaderHeight()){
                consumed[1] = (int) (child.getTranslationY() - getHeaderHeight());
                child.setTranslationY(getHeaderHeight());
            }
            return;
        }

        //处理向上滑动
        float transY =  child.getTranslationY() - dy;
        if(transY >= 0){
            child.setTranslationY(transY);
            consumed[1]= dy;
        }else {
            consumed[1]= (int) child.getTranslationY();
            child.setTranslationY(0);
        }
    }

    /**
     * 获取Header 高度
     * @return
     */
    public int getHeaderHeight(){
        return mHeaderHeight == 0 ? mContext.getResources().getDimensionPixelOffset(R.dimen.header_height) : mHeaderHeight;
    }

}
