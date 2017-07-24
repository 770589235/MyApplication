package com.example.andpay.application;

import android.app.Activity;
import android.os.Bundle;

import com.example.andpay.utils.LogUtil;

/**
 * Created by andpay on 2017/6/22.
 */

public class MyActivityLifeCycleCallbacks  implements MyApplication.ActivityLifecycleCallbacks{
    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
        LogUtil.e("onActivityCreated  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivityStarted(Activity activity) {
        LogUtil.e("onActivityStarted  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivityResumed(Activity activity) {
        LogUtil.e("onActivityResumed  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivityPaused(Activity activity) {
        LogUtil.e("onActivityPaused  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivityStopped(Activity activity) {
        LogUtil.e("onActivityStopped  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        LogUtil.e("onActivitySaveInstanceState  this: "+this+"-----activity: "+activity.getClass().getName());
    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        LogUtil.e("onActivityDestroyed  this: "+this+"-----activity: "+activity.getClass().getName());
    }
}
