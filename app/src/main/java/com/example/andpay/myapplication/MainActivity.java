package com.example.andpay.myapplication;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.login).setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.login:
                Toast.makeText(MainActivity.this, "login button is clicked", Toast.LENGTH_SHORT).show();
                break;
            case R.id.register:
                showProgress();
                break;
            default: break;
        }
    }

    private void showProgress(){
        Dialog  dialog = new Dialog(this, android.R.style.Theme_DeviceDefault_Dialog);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.com_prompt_fln_dialog_layout);
        dialog.setCancelable(true);
        dialog.show();
    }



}
