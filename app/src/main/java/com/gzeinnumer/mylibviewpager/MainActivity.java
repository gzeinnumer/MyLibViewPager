package com.gzeinnumer.mylibviewpager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.gzeinnumer.mylibviewpager.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

//    public static TabLayout dotsTabStatic;

    TabLayout tabLayout;
    SimpleViewPager simpleViewPager;
    TabLayout dotsTab;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        dotsTabStatic = dotsTab;

        tabLayout = findViewById(R.id.tab_layout);
        simpleViewPager = findViewById(R.id.dc);
        dotsTab = findViewById(R.id.dots_tab);

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

//        viewPagerAdapter.addFragment(FirstFragment.instance());
//        viewPagerAdapter.addFragment(FirstFragment.instance());

//        viewPagerAdapter.addFragment(FirstFragment.instance(),"First");
//        viewPagerAdapter.addFragment(FirstFragment.instance(), "Second");

//        viewPagerAdapter.addFragment(FirstFragment.instance(), R.drawable.icon);
//        viewPagerAdapter.addFragment(FirstFragment.instance(), R.drawable.icon);

        viewPagerAdapter.addFragment(FirstFragment.instance(),"First", R.drawable.default_dot);
        viewPagerAdapter.addFragment(FirstFragment.instance(),"Second", R.drawable.default_dot);

        simpleViewPager.setAdapter(viewPagerAdapter)
                .setTabLayout(tabLayout)
//                .setDotsTab(dotsTab, true)
//                .enableSwipe(false)
                .build();

    }
}