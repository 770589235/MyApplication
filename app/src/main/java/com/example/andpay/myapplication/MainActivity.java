package com.example.andpay.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG=MainActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(this);
        Log.e(TAG, TAG+"---onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e(TAG, TAG+"---onStart: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e(TAG, TAG+"---onRestart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, TAG+"---onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e(TAG, TAG+"---onPause: ");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.e(TAG, TAG+"---onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, TAG+"---onDestroy: ");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, TAG+"---onNewIntent: ");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Intent intent=new Intent(this, LoginActivity.class);
                startActivity(intent);
                break;
            default: break;
        }
    }
}
