package com.example.andpay.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import me.andpay.timobileframework.mvc.AbstractEventController;
import me.andpay.timobileframework.mvc.form.FormBean;

/**
 * Created by andpay on 2017/4/21.
 */

public class MainEventController extends AbstractEventController{

    public static final String TAG=MainEventController.class.getName();

    public void onClick(Activity activity, FormBean formBean, View view){
        MainActivity mainActivity=(MainActivity) activity;
        switch (view.getId()){
            case R.id.register:
                Log.d(TAG, "button register is click");
                mainActivity.goRegister();
                break;
            case R.id.login:
                Log.d(TAG, "button login is click");
                mainActivity.goLogin();
                break;
            case R.id.get_package:
                mainActivity.plintPkgAndCls(mainActivity.getResolveInfos());
                break;
            case R.id.get_json_data:
                mainActivity.getJsonData();
                break;
            case R.id.number:
                mainActivity.numberFormat();
                break;
            default: break;
        }
    }
}
