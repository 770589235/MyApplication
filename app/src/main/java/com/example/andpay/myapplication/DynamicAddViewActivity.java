package com.example.andpay.myapplication;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.andpay.application.MyApplication;
import com.example.andpay.utils.Densityutils;
import com.example.andpay.utils.IdiUtils;
import com.example.andpay.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class DynamicAddViewActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{

    private RadioGroup radioGroup;
    private String[] titles={"和付","和徽","和付收银"};
    private int[] icons={R.mipmap.com_fu_icon, R.mipmap.com_hui_icon, R.mipmap.com_yin_icon};
    private int[] ids={R.id.rb_select_apos, R.id.rb_select_npos, R.id.rb_select_cashier};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_add_view);
        radioGroup= (RadioGroup) findViewById(R.id.rg_select_brandcode);
        radioGroup.setOnCheckedChangeListener(this);
        initRadioButton();
    }

    private void initRadioButton(){

        int width = (MyApplication.getmCurrentWidthPixels()-Densityutils.dip2px(26+10*(titles.length-1)))/titles.length;
        for(int i=0;i<titles.length;i++) {
            RadioGroup.LayoutParams lp = new RadioGroup.LayoutParams(width, width);
            RadioButton radioButton = (RadioButton) getLayoutInflater().inflate(R.layout.radiobutton_view, null);
            radioButton.setText(titles[i]);
            radioButton.setCompoundDrawablesWithIntrinsicBounds(null, getResources().getDrawable(icons[i]), null, null);
            radioButton.setId(ids[i]);
            if(i!=0){
                lp.setMargins(Densityutils.dip2px(10f), 0, 0, 0);//设置边距
                radioGroup.addView(radioButton, lp);
            }else{
                radioGroup.addView(radioButton, lp);
            }

        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        for(int i=0;i<ids.length;i++){
            if(checkedId==ids[i]){
                LogUtil.e("onCheckedChanged 点击了"+checkedId);
            }
        }
    }
}
