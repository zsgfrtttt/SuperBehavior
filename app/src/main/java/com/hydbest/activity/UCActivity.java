package com.hydbest.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPager;

import com.hydbest.BaseActivity;
import com.hydbest.behavior.R;
import com.hydbest.fragment.ContentFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by csz on 2018/5/3.
 */

public class UCActivity extends BaseActivity{

    private TabLayout tl;
    private ViewPager vp;
    private List<String> tabIndicators;
    private ArrayList<Fragment> tabFragments;
    private ContentPagerAdapter contentAdapter;
    private String[] strs = {"tab 1","tab 2","tab 3","lebaodai                 1","lebaodai               2","lebaodai             3","这是一个标题 1","这是一个标题 2"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uc);
        initTab();
        initContent();
    }

    private void initTab(){
        tl = findViewById(R.id.tl);
        vp = findViewById(R.id.vp);
        tl.setTabMode(TabLayout.MODE_SCROLLABLE);
        tl.setTabTextColors(Color.GRAY, Color.WHITE);
        tl.setSelectedTabIndicatorColor(Color.WHITE);
        ViewCompat.setElevation(tl, 10);
        tl.setupWithViewPager(vp);
    }

    private void initContent(){
        tabIndicators = new ArrayList<>();
        /*for (int i = 0; i < 3; i++) {
            tabIndicators.add("Tab " + i);
        }*/
        tabIndicators = Arrays.asList(strs);
        tabFragments = new ArrayList<>();
        for (String s : tabIndicators) {
            tabFragments.add(ContentFragment.newInstance(0));
        }
        contentAdapter = new ContentPagerAdapter(getSupportFragmentManager());
        vp.setAdapter(contentAdapter);
    }

    class ContentPagerAdapter extends FragmentPagerAdapter {
        public ContentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
             return tabIndicators.get(position);
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {
            return tabFragments.get(position);
        }

        @Override
        public int getCount() {
            return tabIndicators.size();
        }
    }
}
