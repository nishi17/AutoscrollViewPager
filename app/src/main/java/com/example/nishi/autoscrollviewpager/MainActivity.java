package com.example.nishi.autoscrollviewpager;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private AutoScrollViewPager viewpager;

    private PagerAdapter wrappedAdapter;

    private ImageView iv_dots1, iv_dots2, iv_dots3;

    private List<String> stringList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        initResource();

    }


    private void initResource() {

        stringList = new ArrayList<>();
        stringList.add("Slide1");
        stringList.add("Slide2");
        stringList.add("Slide3");



        iv_dots1 = (ImageView) findViewById(R.id.iv_dots1);
        iv_dots2 = (ImageView) findViewById(R.id.iv_dots2);
        iv_dots3 = (ImageView) findViewById(R.id.iv_dots3);

        setViewPagerData();


    }

    private void setViewPagerData() {

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            int[] colours = new int[]{Color.CYAN, Color.MAGENTA, Color.RED};

            @Override
            public int getCount() {
                return stringList.size();
            }

            @Override
            public Fragment getItem(int position) {
                Fragment fragment = new ColourFragment();
                Bundle args = new Bundle();
                args.putInt("colour", colours[position]);
                args.putInt("identifier", position);
                fragment.setArguments(args);

                //setDotPosition(position);

                return fragment;
            }

        };

        // wrap pager to provide a minimum of 4 pages
        MinFragmentPagerAdapter wrappedMinAdapter = new MinFragmentPagerAdapter(getSupportFragmentManager());
        wrappedMinAdapter.setAdapter(adapter);

        // wrap pager to provide infinite paging with wrap-around
        wrappedAdapter = new InfinitePagerAdapter(wrappedMinAdapter);

        // actually an InfiniteViewPager
        viewpager = (AutoScrollViewPager) findViewById(R.id.viewpager);
        //indicator = (CircleIndicator) findViewById(R.id.indicator);

        viewpager.startAutoScroll();
        viewpager.setInterval(2000);
        viewpager.setCycle(true);
        viewpager.setStopScrollWhenTouch(true);

        viewpager.setAdapter(wrappedAdapter);

        viewpager.setCurrentItem(0);

        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                //Toast.makeText(context,""+position,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onPageSelected(int position) {

                int virtualPosition = position % 3;

                // Toast.makeText(context,""+virtualPosition,Toast.LENGTH_SHORT).show();

                setDotPosition(virtualPosition);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void setDotPosition(int pos) {

        switch (pos) {
            case 0:
                iv_dots1.setBackgroundResource(R.drawable.black_radius);
                iv_dots2.setBackgroundResource(R.drawable.gray_radius);
                iv_dots3.setBackgroundResource(R.drawable.gray_radius);

                break;

            case 1:
                iv_dots1.setBackgroundResource(R.drawable.gray_radius);
                iv_dots2.setBackgroundResource(R.drawable.black_radius);
                iv_dots3.setBackgroundResource(R.drawable.gray_radius);

                break;

            case 2:
                iv_dots1.setBackgroundResource(R.drawable.gray_radius);
                iv_dots2.setBackgroundResource(R.drawable.gray_radius);
                iv_dots3.setBackgroundResource(R.drawable.black_radius);

                break;
        }

    }
}
