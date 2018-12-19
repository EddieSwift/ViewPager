package com.eddie.viewpager;

import android.graphics.Color;
import android.support.annotation.Nullable;
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

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());
        //infinityPager.setOffscreenPageLimit(0);
        infinityPager.setAdapter(adapter);
        infinityPager.setCurrentItem(adapter.getCount() / 2, false);

    }

    class MyAdapter extends FragmentStatePagerAdapter {

        private PageFragment[] arr;

        public MyAdapter(FragmentManager fm) {

            super(fm);

            arr = new PageFragment[10];
            Random random = new Random();
            /*
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int color = Color.rgb(r, g, b);
            */

            for (int i = 0; i < 10; i++) {

                arr[i] = PageFragment.newInstance(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)), i);
            }

        }

        @Override
        public Fragment getItem(int position) {

            /*
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            int color = Color.rgb(r, g, b);

            return PageFragment.newInstance(color, position);
            */

            return arr[position % arr.length];
        }

        @Override
        public int getCount() { // Count how many fragments we want to create

            return 1000;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {

            return "Page " + position % arr.length;
            //return super.getPageTitle(position);
        }
    }
}
