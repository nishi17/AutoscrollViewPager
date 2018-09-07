package com.example.nishi.autoscrollviewpager;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.Scroller;

/**
 * Created by Admin on 7/31/2017.
 */

public class CustomDurationScroller extends Scroller {

//    private double scrollFactor = 5000;
//
//    public CustomDurationScroller(Context context) {
//        super(context);
//    }
//
//    public CustomDurationScroller(Context context, Interpolator interpolator) {
//        super(context, interpolator);
//    }
//
//    public void setScrollDurationFactor(double scrollFactor) {
//        this.scrollFactor = scrollFactor;
//    }
//
//    @Override
//    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
//        super.startScroll(startX, startY, dx, dy, (int)(duration * scrollFactor));
//    }


    private int mDuration = 1000;

    public CustomDurationScroller(Context context) {
        super(context);
    }

    public CustomDurationScroller(Context context, Interpolator interpolator) {
        super(context, interpolator);
    }

    public CustomDurationScroller(Context context, Interpolator interpolator, boolean flywheel) {
        super(context, interpolator, flywheel);
    }


    @Override
    public void startScroll(int startX, int startY, int dx, int dy, int duration) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

    @Override
    public void startScroll(int startX, int startY, int dx, int dy) {
        // Ignore received duration, use fixed one instead
        super.startScroll(startX, startY, dx, dy, mDuration);
    }

}
