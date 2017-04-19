package com.example.andpay.myapplication;

import android.os.Bundle;
import android.widget.Button;

import me.andpay.timobileframework.flow.activity.TiFlowActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;


@ContentView(R.layout.activity_main)
public class MainActivity extends TiFlowActivity{

    @InjectView(R.id.login)
    private Button button;


    @Override
    protected void doCreate(Bundle savedInstanceState) {
        super.doCreate(savedInstanceState);
    }




}
