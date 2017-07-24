package com.example.andpay.myapplication;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.andpay.application.MyApplication;
import com.example.andpay.cmview.GuideView;
import com.example.andpay.utils.Densityutils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private GuideView guideView;
    private GuideView guideView3;
    private GuideView guideView2;

    private Button button;
    private LinearLayout testlayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.login);
        button.setOnClickListener(this);
        findViewById(R.id.register).setOnClickListener(this);
        testlayout= (LinearLayout) findViewById(R.id.testlayout);
    }

    private void setGuideView() {

        // 使用图片
        final ImageView iv = new ImageView(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Densityutils.dip2px(80), Densityutils.dip2px(80));
        iv.setLayoutParams(params);
        iv.setImageResource(R.mipmap.com_homepage_fastpay_guide);

        // 使用文字
        TextView tv = new TextView(this);
        tv.setText("欢迎使用");
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setTextSize(30);
        tv.setGravity(Gravity.CENTER);

        // 使用文字
        final TextView tv2 = new TextView(this);
        tv2.setText("欢迎使用2");
        tv2.setTextColor(getResources().getColor(R.color.white));
        tv2.setTextSize(30);
        tv2.setGravity(Gravity.CENTER);


        guideView = GuideView.Builder
                .newInstance(this)
                .setTargetView(testlayout)//设置目标
                .setCustomGuideView(iv)
                .setDirction(GuideView.Direction.LEFT_BOTTOM)
                .setOffset(MyApplication.getmCurrentWidthPixels()/2,0)
                .setShape(GuideView.MyShape.CIRCULAR)   // 设置圆形显示区域，
                .setBgColor(getResources().getColor(R.color.shadow))
                .setOnclickListener(new GuideView.OnClickCallback() {
                    @Override
                    public void onClickedGuideView() {
                        guideView.hide();
                    }
                })
                .build();


//        guideView2 = GuideView.Builder
//                .newInstance(this)
//                .setTargetView(btnTest)
//                .setCustomGuideView(tv)
//                .setDirction(GuideView.Direction.LEFT_BOTTOM)
//                .setShape(GuideView.MyShape.ELLIPSE)   // 设置椭圆形显示区域，
//                .setBgColor(getResources().getColor(R.color.shadow))
//                .setOnclickListener(new GuideView.OnClickCallback() {
//                    @Override
//                    public void onClickedGuideView() {
//                        guideView2.hide();
//                        guideView3.show();
//                    }
//                })
//                .build();
//
//
//        guideView3 = GuideView.Builder
//                .newInstance(this)
//                .setTargetView(btnTest2)
//                .setCustomGuideView(tv2)
//                .setDirction(GuideView.Direction.LEFT_BOTTOM)
//                .setShape(GuideView.MyShape.RECTANGULAR)   // 设置矩形显示区域，
//                .setRadius(80)          // 设置圆形或矩形透明区域半径，默认是targetView的显示矩形的半径，如果是矩形，这里是设置矩形圆角大小
//                .setBgColor(getResources().getColor(R.color.shadow))
//                .setOnclickListener(new GuideView.OnClickCallback() {
//                    @Override
//                    public void onClickedGuideView() {
//                        guideView3.hide();
//                        guideView.show();
//                    }
//                })
//                .build();

        guideView.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        setGuideView();
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
