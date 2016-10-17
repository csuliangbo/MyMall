package com.example.frank.mymall.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioGroup;

import com.example.frank.mymall.R;
import com.example.frank.mymall.fragment.CategoryFragment;
import com.example.frank.mymall.fragment.HomeFragment;
import com.example.frank.mymall.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private static final String TAG = "MainActivity";
    private RadioGroup mRadioGroup;
    private ViewPager mViewPager;
    private List<Fragment> fragments = new ArrayList<Fragment>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        mRadioGroup = (RadioGroup) findViewById(R.id.view_radiogroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.id_rb_home:
                        mViewPager.setCurrentItem(0, true);
                        break;
                    case R.id.id_rb_category:
                        mViewPager.setCurrentItem(1, true);
                        break;
                    case R.id.id_rb_me:
                        mViewPager.setCurrentItem(2, true);
                        break;
                }
            }
        });


        mViewPager = (ViewPager) findViewById(R.id.view_viewpager);
        HomeFragment homeFragment = new HomeFragment();
        CategoryFragment categoryFragment = new CategoryFragment();
        MeFragment meFragment = new MeFragment();
        fragments.add(homeFragment);
        fragments.add(categoryFragment);
        fragments.add(meFragment);
        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });
        mViewPager.setCurrentItem(0);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        mRadioGroup.check(R.id.id_rb_home);
                        break;
                    case 1:
                        mRadioGroup.check(R.id.id_rb_category);
                        break;
                    case 2:
                        mRadioGroup.check(R.id.id_rb_me);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }
}
