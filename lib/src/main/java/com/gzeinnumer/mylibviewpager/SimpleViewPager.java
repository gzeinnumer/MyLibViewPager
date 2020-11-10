package com.gzeinnumer.mylibviewpager;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;
import com.gzeinnumer.mylibviewpager.adapter.ViewPagerAdapter;
import com.gzeinnumer.mylibviewpager.ui.ViewPagerNonSwipable;

import java.util.ArrayList;

public class SimpleViewPager extends LinearLayout {
    Context context;
    AttributeSet attrs;

    public SimpleViewPager(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        this.attrs = attrs;

        initView();
    }

    TabLayout tabLayout = null;
    ViewPagerNonSwipable viewPager;
    TabLayout dotsTab = null;

    ViewPagerAdapter viewPagerAdapter;

    boolean enableClickDot = false;
    boolean enableSwipe = true;

    private void initView() {
        inflate(context, R.layout.custom_viewpager, this);

        viewPager = findViewById(R.id.view_pager);
    }

    public SimpleViewPager setAdapter(ViewPagerAdapter adapter){
        viewPagerAdapter = adapter;
        return this;
    }

    public void build(){

        viewPager.setSwipeable(enableSwipe);
        viewPager.setAdapter(viewPagerAdapter);
        if (tabLayout!=null){
            tabLayout.setupWithViewPager(viewPager);

            if (viewPagerAdapter.getFragments().size()>0){
                for (int i=0; i<viewPagerAdapter.getIcons().size(); i++){
                    tabLayout.getTabAt(i).setIcon(viewPagerAdapter.getIcons().get(i));
                }
            }
        } else if (dotsTab!=null){
            viewPagerAdapter.setTitles(new ArrayList<>());
            viewPagerAdapter.setIcons(new ArrayList<>());

            dotsTab.setupWithViewPager(viewPager);

            if (!enableClickDot){
                LinearLayout tabStrip = ((LinearLayout) dotsTab.getChildAt(0));
                for (int i = 0; i < tabStrip.getChildCount(); i++) {
                    tabStrip.getChildAt(i).setOnTouchListener(new View.OnTouchListener() {
                        @Override
                        public boolean onTouch(View v, MotionEvent event) {
                            return true;
                        }
                    });
                }
            }
        }
    }

    public SimpleViewPager enableSwipe(boolean enableSwipe) {
        this.enableSwipe = enableSwipe;
        return this;
    }

    public SimpleViewPager setTabLayout(TabLayout tabLayout) {
        this.tabLayout = tabLayout;
        return this;
    }

    public SimpleViewPager setDotsTab(TabLayout dotsTab, boolean enableClickDot) {
        this.dotsTab = dotsTab;
        this.enableClickDot = enableClickDot;
        return this;
    }
}
