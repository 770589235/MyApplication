package com.example.andpay.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.andpay.exception.GlobalException;
import com.example.andpay.utils.LogUtil;


/**
 * Created by Administrator on 2016/8/19.
 */
public class MyApplication extends Application {


    private static int mCurrentWidthPixels;
    private static int mCurrentHeightPixels;
    private static Context context;
    @Override
    public void onCreate() {
        super.onCreate();
        context=this;
        GlobalException exception = GlobalException.getInstance();
        exception.init(this);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) getApplicationContext().getSystemService(
                Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(
                displayMetrics);
        mCurrentWidthPixels = displayMetrics.widthPixels;
        mCurrentHeightPixels = displayMetrics.heightPixels;

        LogUtil.e("屏幕的宽:"+mCurrentWidthPixels+", 屏幕的高:"+mCurrentHeightPixels);

        registerActivityLifecycleCallbacks(new MyActivityLifeCycleCallbacks());
    }

    public static Context getContext() {
        return context;
    }

    public static int getmCurrentWidthPixels() {
        return mCurrentWidthPixels;
    }

    public static int getmCurrentHeightPixels() {
        return mCurrentHeightPixels;
    }



}
