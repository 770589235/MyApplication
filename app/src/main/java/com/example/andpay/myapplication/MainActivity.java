package com.example.andpay.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

import me.andpay.timobileframework.flow.activity.TiFlowActivity;
import me.andpay.timobileframework.mvc.anno.EventDelegate;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.activity_main)
public class MainActivity extends TiFlowActivity{

    private static final String TAG=MainActivity.class.getName();

    @InjectView(R.id.login)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button login;

    @InjectView(R.id.register)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button register;

    @InjectView(R.id.get_package)
    @EventDelegate(isPassFastClick = true, delegateClass = View.OnClickListener.class, toEventController = MainEventController.class)
    private Button getInfo;

    @InjectView(R.id.info)
    private TextView info;

    @Override
    protected void doCreate(Bundle savedInstanceState) {
        super.doCreate(savedInstanceState);
    }

    /**
     * 注册页面
     */
    public void goRegister(){


    }

    /**
     * 登陆页面
     */
    public void goLogin(){

    }


    public void plintPkgAndCls(List<ResolveInfo> resolveInfos){
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < resolveInfos.size(); i++) {
            String pkg = resolveInfos.get(i).activityInfo.packageName;
            String cls = resolveInfos.get(i).activityInfo.name;
            sb.append(pkg+"..."+cls+"\n");
        }
        info.setText(sb.toString());
    }

    public List<ResolveInfo> getResolveInfos(){
        List<ResolveInfo> appList = null;

        Intent intent = new Intent(Intent.ACTION_MAIN, null);
        intent.addCategory(Intent.CATEGORY_LAUNCHER);
        PackageManager pm = getPackageManager();
        appList = pm.queryIntentActivities(intent, 0);
        Collections.sort(appList, new ResolveInfo.DisplayNameComparator(pm));

        return appList;
    }


}
