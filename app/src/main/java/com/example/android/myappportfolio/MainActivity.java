package com.example.android.myappportfolio;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private Drawable mActionBarBackgroundDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setStatusBarTranslucent(true);

        mActionBarBackgroundDrawable = new ColorDrawable(Color.parseColor("#03A9F4"));
        mActionBarBackgroundDrawable.setAlpha(0);

        getActionBar().setBackgroundDrawable(mActionBarBackgroundDrawable);

        ((NotifyingScrollView) findViewById(R.id.scroll_view)).setOnScrollChangedListener(mOnScrollChangedListener);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN_MR1) {
            mActionBarBackgroundDrawable.setCallback(mDrawableCallback);
        }
    }
    /*
    protected void setStatusBarTranslucent(boolean makeTranslucent){
        if (makeTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        } else {
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }*/

    private NotifyingScrollView.OnScrollChangedListener mOnScrollChangedListener = new NotifyingScrollView.OnScrollChangedListener() {
        public void onScrollChanged(ScrollView who, int l, int t, int oldl, int oldt) {
            final int headerHeight = findViewById(R.id.image_header).getHeight() - getActionBar().getHeight();
            final float ratio = (float) Math.min(Math.max(t, 0), headerHeight) / headerHeight;
            final int newAlpha = (int) (ratio * 255);
            mActionBarBackgroundDrawable.setAlpha(newAlpha);
        }
    };

    private Drawable.Callback mDrawableCallback = new Drawable.Callback() {
        @Override
        public void invalidateDrawable(Drawable who) {
            getActionBar().setBackgroundDrawable(who);
        }

        @Override
        public void scheduleDrawable(Drawable who, Runnable what, long when) {
        }

        @Override
        public void unscheduleDrawable(Drawable who, Runnable what) {
        }
    };

    public void populatMoviesToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Popular Movies app!",
                Toast.LENGTH_SHORT).show();
    }

    public void stockHawkToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Stock Hawk app!",
                Toast.LENGTH_SHORT).show();
    }

    public void buildItBiggerToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Build it Bigger app!",
                Toast.LENGTH_SHORT).show();
    }

    public void makeYourAppToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Make Your App Material app!",
                Toast.LENGTH_SHORT).show();
    }

    public void ubiquitousToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Go Uiquitous app!",
                Toast.LENGTH_SHORT).show();
    }

    public void capstoneToast(View view) {
        Toast.makeText(MainActivity.this, "This button will launch my Capstone app!",
                Toast.LENGTH_SHORT).show();
    }
}
