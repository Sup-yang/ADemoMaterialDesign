package com.example.yang.ademomaterialdesign;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by yang on 2017/6/26.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mfragments;
    private List<String> mtitles;



    public FragmentAdapter(FragmentManager fm,List<Fragment> fragments,List<String> titles) {
        super(fm);
        mfragments=fragments;
        mtitles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mfragments.get(position);
    }

    @Override
    public int getCount() {
        return mfragments.size();
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return mtitles.get(position);
    }
}
