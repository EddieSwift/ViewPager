package com.eddie.viewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button prevBtn, nextBtn, startBtn, endBtn;
    private ViewPager myPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prevBtn = findViewById(R.id.prev_btn);
        prevBtn.setOnClickListener(this);

        nextBtn = findViewById(R.id.next_btn);
        nextBtn.setOnClickListener(this);

        startBtn = findViewById(R.id.start_btn);
        startBtn.setOnClickListener(this);

        endBtn = findViewById(R.id.end_btn);
        endBtn.setOnClickListener(this);

        MyAdapter adapter = new MyAdapter(getSupportFragmentManager());

        myPager = findViewById(R.id.my_view_pager);

        myPager.setOffscreenPageLimit(2);
        myPager.setAdapter(adapter);

        myPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                Log.d("SCROLLED", "onPageScrolled() called with: i = [" + i + "], v = [" + v + "], i1 = [" + i1 + "]");
            }

            @Override
            public void onPageSelected(int i) {

                Log.d("SELECTED", "onPageSelected() called with: i = [" + i + "]");
            }

            @Override
            public void onPageScrollStateChanged(int i) {

                switch (i) {
                    case ViewPager.SCROLL_STATE_IDLE:
                        Log.d("MY_TAG", "IDLE");
                        break;
                    case ViewPager.SCROLL_STATE_SETTLING:
                        Log.d("MY_TAG", "SETTLING");
                        break;
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        Log.d("MY_TAG", "DRAGGING");
                        break;
                }
            }
        });


    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.prev_btn) {

            int position = myPager.getCurrentItem();

            if (position > 0) {

                myPager.setCurrentItem(--position);
            }

        } else if (v.getId() == R.id.next_btn) {

            int position = myPager.getCurrentItem();
            int count = myPager.getAdapter().getCount();

            if (position < count - 1) {

                myPager.setCurrentItem(++position);
            }

        } else if (v.getId() == R.id.start_btn) {

            myPager.setCurrentItem(0, false);

        } else if (v.getId() == R.id.end_btn) {

            myPager.setCurrentItem(myPager.getAdapter().getCount() - 1, true);
        }

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

            return 10;
        }
    }
}
