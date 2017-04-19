package com.example.andpay.myapplication;

import android.content.Context;
import me.andpay.timobileframework.mvc.context.TiAndroidContextProvider;
import me.andpay.timobileframework.mvc.context.TiContextProvider;
import me.andpay.timobileframework.mvc.support.TiActivityLifecycleCallbacks;
import me.andpay.timobileframework.mvc.support.TiApplication;
import me.andpay.timobileframework.util.LoadPatchUtil;
import me.andpay.timobileframework.util.LogUtil;
import me.andpay.timobileframework.util.PackageUtil;
import me.andpay.timobileframework.util.WebSocketConfigUtil;

public class MyTiApplication extends TiApplication {
    private TiContextProvider provider;
    private static Context mContext;
    private TiActivityLifecycleCallbacks callbacks;

    public MyTiApplication() {
    }

    public void onCreate() {
        super.onCreate();
        LogUtil.i(this.getClass().getName(), "TiDataContext get Attribute , provider is " + (this.provider == null));
        mContext = this.getApplicationContext();
        this.registerActivityLifecycleCallbacks(this.callbacks);
    }

    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);


        this.provider = new TiAndroidContextProvider(this, this.getClass().getSimpleName());
        this.initializeApp();
        LoadPatchUtil.loadPatch(this);
        this.callbacks = new TiActivityLifecycleCallbacks();
        LogUtil.d(this.getClass().getName(), "attachBaseContext");
    }

    private void initializeApp() {
        LogUtil.isDebug = PackageUtil.isDebugMode(this);
        WebSocketConfigUtil.loadLocalChannel(this);
    }

    public TiContextProvider getContextProvider() {
        return this.provider;
    }

    public static Context getContextObject() {
        return mContext;
    }

    public void onTerminate() {
        LogUtil.i(this.getClass().getName(), "the application has terminate");
        super.onTerminate();
        this.unregisterActivityLifecycleCallbacks(this.callbacks);
    }
}