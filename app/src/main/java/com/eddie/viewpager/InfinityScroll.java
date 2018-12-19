package com.eddie.viewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class InfinityScroll extends AppCompatActivity {

    private ViewPager infinityPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infinity_scroll);

        infinityPager = findViewById(R.id.infinity_page_view);

        final MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        //infinityPager.setOffscreenPageLimit(0);
        infinityPager.setAdapter(adapter);
        infinityPager.setCurrentItem(adapter.getCount() / 2);

    }

    class MyAdapter extends FragmentStatePagerAdapter {


        public MyAdapter(FragmentManager fm) {

            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int color = Color.rgb(r, g, b);

            return PageFragment.newInstance(color, position);
        }

        @Override
        public int getCount() { // Count how many fragments we want to create

            return 1000;
        }
    }
}
