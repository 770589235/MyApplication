package com.example.andpay.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG=LoginActivity.class.getName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        findViewById(R.id.back).setOnClickListener(this);
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
            case R.id.back:
                Intent intent=new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
            default: break;
        }
    }
}
