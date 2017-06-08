package com.example.andpay.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String TAG=MainActivity.class.getName();

    private EditText et_amount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_amount=(EditText) findViewById(R.id.amount);
        findViewById(R.id.login).setOnClickListener(this);
        Log.e(TAG, TAG+"---onCreate: ");
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(8000);
                    BigDecimal bd=new BigDecimal(et_amount.getText().toString().trim()).setScale(2,BigDecimal.ROUND_HALF_UP);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    private void init(){
        String amount=et_amount.getText().toString().trim();
        if(TextUtils.isEmpty(amount)){
            return;
        }

        BigDecimal bd=new BigDecimal(amount).setScale(2,BigDecimal.ROUND_HALF_UP);

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

    private int count;
    @Override
    protected void onResume() {
        super.onResume();
        Log.e(TAG, TAG+"---onResume: "+count);
        if(count++==1){
            et_amount.getText().clear();
        }
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
