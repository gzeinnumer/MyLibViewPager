package com.gzeinnumer.mylibviewpager.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    private ArrayList<String> titles;
    private ArrayList<Integer> icons;

    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.fragments = new ArrayList<>();
        this.titles = new ArrayList<>();
        this.icons = new ArrayList<>();
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    public void addFragment(Fragment fr){
        fragments.add(fr);
    }

    public void addFragment(Fragment fr, String title){
        fragments.add(fr);
        titles.add(title);
    }

    public void addFragment(Fragment fr, int icon){
        fragments.add(fr);
        icons.add(icon);
    }

    public void addFragment(Fragment fr, String title, int icon){
        fragments.add(fr);
        titles.add(title);
        icons.add(icon);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles.size()>0)
            return titles.get(position);
        else
            return null;
    }

    public ArrayList<Fragment> getFragments() {
        return fragments;
    }

    public ArrayList<String> getTitles() {
        return titles;
    }

    public ArrayList<Integer> getIcons() {
        return icons;
    }

    public void setTitles(ArrayList<String> titles) {
        this.titles = titles;
    }

    public void setIcons(ArrayList<Integer> icons) {
        this.icons = icons;
    }
}
